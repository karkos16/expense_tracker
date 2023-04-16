package com.example.expensetracker.ui.viewModels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.domain.useCase.ValidateEmail
import com.example.expensetracker.domain.useCase.ValidatePassword
import com.example.expensetracker.domain.useCase.ValidateTerms
import com.example.expensetracker.repos.AuthRepository
import com.example.expensetracker.ui.onEvents.RegistrationFormEvent
import com.example.expensetracker.ui.viewModels.states.RegistrationFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateTerms: ValidateTerms
): ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

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

        val hasError = listOf(
            emailResult,
            passwordResult,
            termsResult
        ).any { !it.successful }
        state = state.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            termsError = termsResult.errorMessage
        )
        if (hasError) { return }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }

    suspend fun signUp(): Boolean {
        return try {
            authRepository.signUpWithEmailAndPassword(state.email, state.password)
            true // Sign up successful
        } catch (e: Exception) {
            false // Sign up failed
        }
    }

    fun signUpWithGoogle() {
//        TODO: Signup with google
    }
}