package com.example.expensetracker.ui.viewModels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.domain.useCase.ValidateEmail
import com.example.expensetracker.repos.AuthRepository
import com.example.expensetracker.ui.onEvents.LoginFormEvent
import com.example.expensetracker.ui.onEvents.RegistrationFormEvent
import com.example.expensetracker.ui.viewModels.states.LoginFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val emailValidator: ValidateEmail,
): ViewModel() {

    var state by mutableStateOf(LoginFormState())

    private val validationEventChannel = Channel<LoginViewModel.ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = emailValidator.execute(state.email)

        val hasError = listOf(
            emailResult
        ).any { !it.successful }
        state = state.copy(emailError = emailResult.errorMessage)
        if (hasError) {return}
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
    suspend fun login(): Boolean {
        return try {
            authRepository.signInWithEmailAndPassword(state.email, state.password)
            true
        } catch (e: Exception) {
            Log.d("AUTH", e.message.toString())
            false
        }
    }



}