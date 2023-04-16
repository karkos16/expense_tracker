package com.example.expensetracker.ui.screens.authScreens.signUpScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.onEvents.RegistrationFormEvent
import com.example.expensetracker.ui.screens.NavGraphs
import com.example.expensetracker.ui.screens.authScreens.authComponents.TopNavigation
import com.example.expensetracker.ui.screens.authScreens.authComponents.InputField
import com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents.SignUpGoogleButton
import com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents.TermsAgreement
import com.example.expensetracker.ui.screens.destinations.OnBoardingScreenDestination
import com.example.expensetracker.ui.screens.onBoardingScreen.components.LongButton
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Violet100
import com.example.expensetracker.ui.viewModels.SignUpViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Destination
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = Dispatchers.IO) {
        viewModel.validationEvents.collect { event ->
            when(event) {
                is SignUpViewModel.ValidationEvent.Success -> {
                    if (viewModel.signUp()) {
                        Toast.makeText(
                            context,
                            "Sign up successful",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Sign up failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        TopNavigation(
            text = "Sign Up",
            onClickNavigation = {
                navigator.navigate(OnBoardingScreenDestination()) {
                    popUpTo(OnBoardingScreenDestination.route)
                }
            }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { InputField(
                label = "Name",
                isPasswordType = false,
                state.name,
                onValueChange = {
                        viewModel.onEvent(RegistrationFormEvent.NameChanged(it))
                    },
                isError = null
                )
            }
            item { InputField(
                label = "Email",
                isPasswordType = false,
                value = state.email,
                onValueChange = {
                        viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
                    },
                isError = state.emailError
                )
                if (state.emailError != null) {
                    Text(text = state.emailError, color = MaterialTheme.colors.error)
                }
            }
            item { InputField(
                label = "Password",
                isPasswordType = true,
                value = state.password,
                onValueChange = {
                        viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
                    },
                isError = state.passwordError
                )
                if (state.passwordError != null) {
                    Text(text = state.passwordError, color = MaterialTheme.colors.error)
                }
            }
            item {
                TermsAgreement(
                    checkState = state.acceptedTerms,
                    onCheckedChange = {
                        viewModel.onEvent(RegistrationFormEvent.AcceptTerms(it) )
                    }
                )
                if (state.termsError != null) {
                    Text(text = state.termsError, color = MaterialTheme.colors.error)
                }
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { LongButton(
                backgroundColor = Violet100,
                textColor = BaseLight80,
                text = "Sign Up",
                onClickAction = { viewModel.onEvent(RegistrationFormEvent.Submit) }
            )
            }
            item { Text(
                text = "Or with",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = BaseLight20
            )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { SignUpGoogleButton {
                Toast.makeText(
                    context,
                    "Google sign Up",
                    Toast.LENGTH_LONG
                ).show()
                }
            }
            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Already have an account? ", color = BaseLight20, fontSize = 16.sp)
                    Text(text = "Login", color = Violet100, fontSize = 16.sp, textDecoration = TextDecoration.Underline)
                }
            }
        }
    }
}