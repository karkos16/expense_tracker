package com.example.expensetracker.ui.screens.authScreens.loginScreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.screens.authScreens.authComponents.InputField
import com.example.expensetracker.ui.screens.authScreens.authComponents.TopNavigation
import com.example.expensetracker.ui.screens.onBoardingScreen.components.LongButton
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Violet100
import com.example.expensetracker.ui.viewModels.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        val emailState = viewModel.emailState.collectAsState()
        val passwordState = viewModel.emailState.collectAsState()
        TopNavigation(text = "Login", { Log.d("KLIK", "Wroc")})
        InputField(
            label = "Email",
            isPasswordType = false,
            emailState.value
        ) { viewModel.onEmailChanged(it) }
        InputField(
            label = "Password",
            isPasswordType = true,
            passwordState.value
        ) { viewModel.onPasswordChanged(it) }
        Spacer(modifier = Modifier.height(30.dp))
        LongButton(backgroundColor = Violet100, textColor = BaseLight80, text = "Login", { println("KLIK") })
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

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen()
}