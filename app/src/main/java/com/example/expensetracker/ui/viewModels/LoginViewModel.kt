package com.example.expensetracker.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.expensetracker.repos.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {

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

    fun login(): () -> Unit {
        return {
            CoroutineScope(Dispatchers.IO).launch {
                authRepository.signInWithEmailAndPassword(_emailState.value, _passwordState.value)
            }
        }
    }



}