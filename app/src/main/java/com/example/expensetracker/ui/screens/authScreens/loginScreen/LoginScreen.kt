package com.example.expensetracker.ui.screens.authScreens.loginScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.onEvents.LoginFormEvent
import com.example.expensetracker.ui.screens.authScreens.authComponents.InputField
import com.example.expensetracker.ui.screens.authScreens.authComponents.TopNavigation
import com.example.expensetracker.ui.screens.destinations.OnBoardingScreenDestination
import com.example.expensetracker.ui.screens.onBoardingScreens.components.LongButton
import com.example.expensetracker.ui.theme.BaseDark50
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Violet100
import com.example.expensetracker.ui.viewModels.LoginViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.Dispatchers

@Destination
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        val state = viewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = Dispatchers.IO) {
            viewModel.validationEvents.collect { _ ->
                if (viewModel.login()) {
                    Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
        }

        TopNavigation(
            text = "Login",
            color = BaseDark50,
            onClickNavigation = {
                navigator.navigate(OnBoardingScreenDestination()) {
                    popUpTo(OnBoardingScreenDestination.route)
                }
            }
        )
        InputField(
            label = "Email",
            isPasswordType = false,
            value = state.email,
            onValueChange = { viewModel.onEvent(LoginFormEvent.EmailChanged(it)) },
            isError = state.emailError
        )
        if (state.emailError != null) {
            Text(text = state.emailError, color = MaterialTheme.colors.error)
        }
        InputField(
            label = "Password",
            isPasswordType = true,
            value = state.password,
            onValueChange = { viewModel.onEvent(LoginFormEvent.PasswordChanged(it)) },
            isError = null
        )
        Spacer(modifier = Modifier.height(30.dp))
        LongButton(
            backgroundColor = Violet100,
            textColor = BaseLight80,
            text = "Login",
            onClickAction = { viewModel.onEvent(LoginFormEvent.Submit) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Forgot Password?", color = Violet100, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = BaseLight20)) {
                        append("Don't have an account yet? ")
                    }
                    withStyle(style = SpanStyle(color = Violet100, textDecoration = TextDecoration.Underline)) {
                        append("Sign Up")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}