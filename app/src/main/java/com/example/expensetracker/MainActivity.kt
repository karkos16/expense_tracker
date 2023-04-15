package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.expensetracker.ui.screens.NavGraphs
import com.example.expensetracker.ui.screens.authScreens.loginScreen.LoginScreen
import com.example.expensetracker.ui.screens.authScreens.signUpScreen.SignUpScreen
import com.example.expensetracker.ui.screens.onBoardingScreen.OnBoardingScreen
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}