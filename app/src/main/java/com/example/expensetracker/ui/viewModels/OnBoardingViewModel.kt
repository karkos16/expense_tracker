package com.example.expensetracker.ui.viewModels

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.expensetracker.R
import com.example.expensetracker.ui.screens.authScreens.loginScreen.LoginScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(): ViewModel() {
    private val images = listOf(
        listOf<Any>(
            R.drawable.money,
            "Gain total control of your money",
            "Become your own money manager and make every cent count"
        ),
        listOf<Any>(
            R.drawable.money_go,
            "Know where your money goes",
            "Track your transaction easily, with categories and financial report"
        ),
        listOf<Any>(
            R.drawable.planing,
            "Planing ahead",
            "Setup your budget for each category so you in control"
        )
    )

    fun getImageIds(): List<List<Any>> {
        return images
    }

    fun navigateToLoginScreen(): () -> Unit {
        return { Log.d("NAV", "Navigate to LoginScreen") }
    }

    fun navigateToSignUpScreen(): () -> Unit {
        return { Log.d("NAV", "Navigate to SignUpScreen") }
    }
}