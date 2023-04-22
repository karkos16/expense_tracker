package com.example.expensetracker.ui.viewModels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.domain.useCase.ValidateEmail
import com.example.expensetracker.domain.useCase.ValidateName
import com.example.expensetracker.domain.useCase.ValidatePassword
import com.example.expensetracker.domain.useCase.ValidateTerms
import com.example.expensetracker.repos.AuthRepository
import com.example.expensetracker.ui.onEvents.RegistrationFormEvent
import com.example.expensetracker.ui.viewModels.states.RegistrationFormState
import com.google.firebase.auth.UserProfileChangeRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateTerms: ValidateTerms,
    private val validateName: ValidateName
): ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun getUserName(): String? {
        return authRepository.getCurrentUser()?.displayName
    }

    fun onEvent(event: RegistrationFormEvent) {
        when(event) {
            is RegistrationFormEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val termsResult = validateTerms.execute(state.acceptedTerms)
        val nameResult = validateName.execute(state.name)

        val hasError = listOf(
            emailResult,
            passwordResult,
            termsResult,
            nameResult
        ).any { !it.successful }
        state = state.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            termsError = termsResult.errorMessage,
            nameError = nameResult.errorMessage
        )
        if (hasError) { return }
        viewModelScope.launch {
            val isSignUpSuccessful = signUp()
            if (isSignUpSuccessful) {
                validationEventChannel.send(ValidationEvent.Success)
            } else {
                validationEventChannel.send(ValidationEvent.Failure)
            }
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
        object Failure: ValidationEvent()
    }

    suspend fun signUp(): Boolean {
        return try {
            authRepository.signUpWithEmailAndPassword(state.email, state.password)
            val profileUpdate = UserProfileChangeRequest.Builder().setDisplayName(state.name).build()
            authRepository.getCurrentUser()?.updateProfile(profileUpdate)
            true // Sign up successful
        } catch (e: Exception) {
            false // Sign up failed
        }
    }

    fun signUpWithGoogle() {
//        TODO: Signup with google
    }
}