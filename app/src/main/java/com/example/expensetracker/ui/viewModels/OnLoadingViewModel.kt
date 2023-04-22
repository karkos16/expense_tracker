package com.example.expensetracker.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.expensetracker.repos.AuthRepository
import com.google.firebase.auth.EmailAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnLoadingViewModel @Inject constructor(
    authRepository: AuthRepository
): ViewModel() {
    private val user = authRepository.getCurrentUser()

    fun isUserLoggedIn(): Boolean {
        return user != null
    }
}