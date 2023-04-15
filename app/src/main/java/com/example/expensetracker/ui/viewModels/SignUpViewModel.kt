package com.example.expensetracker.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.expensetracker.repos.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {

    private var _nameState = MutableStateFlow("")
    val nameState: StateFlow<String> = _nameState

    private var _emailState = MutableStateFlow("")
    val emailState: StateFlow<String> = _emailState

    private var _passwordState = MutableStateFlow("")
    val passwordState: StateFlow<String> = _passwordState

    private var _termsState = MutableStateFlow(false)
    val termsState: StateFlow<Boolean> = _termsState

    fun onNameChanged(name: String) {
        _nameState.value = name
    }

    fun onEmailChanged(email: String) {
        _emailState.value = email
    }

    fun onPasswordChanged(password: String) {
        _passwordState.value = password
    }

    fun onTermsChanged() {
        _termsState.value = !_termsState.value
    }

    fun signUp(): () -> Unit {
        return {
            CoroutineScope(Dispatchers.IO).launch {
                authRepository.signUpWithEmailAndPassword(_emailState.value, _passwordState.value)
            }
        }
    }

    fun signUpWithGoogle() {
//        TODO: Signup with google
    }
}