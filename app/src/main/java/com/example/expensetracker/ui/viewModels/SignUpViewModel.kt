package com.example.expensetracker.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {

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
            Log.d("AUTH", "Name: ${_nameState.value}")
            Log.d("AUTH", "Email: ${_emailState.value}")
            Log.d("AUTH", "Password: ${_passwordState.value}")
        }
    }

    fun signUpWithGoogle() {
//        TODO: Signup with google
    }
}