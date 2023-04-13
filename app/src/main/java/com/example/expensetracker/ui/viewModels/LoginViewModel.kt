package com.example.expensetracker.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private var _emailState = MutableStateFlow("")
    val emailState: StateFlow<String> = _emailState

    private var _passwordState = MutableStateFlow("")
    val passwordState: StateFlow<String> = _passwordState

    fun onEmailChanged(email: String) {
        _emailState.value = email
    }

    fun onPasswordChanged(password: String) {
        _passwordState.value = password
    }



}