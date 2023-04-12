package com.example.expensetracker.ui.screens.authScreens.signUpScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.screens.authScreens.authComponents.TopNavigation
import com.example.expensetracker.ui.screens.authScreens.authComponents.InputField
import com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents.SignUpGoogleButton
import com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents.TermsAgreement
import com.example.expensetracker.ui.screens.onBoardingScreen.components.LongButton
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Violet100

@Composable
fun SignUpScreen() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        TopNavigation(
            text = "Sign Up",
            onClickNavigation = { Toast.makeText(
                context,
                "Wroc",
                Toast.LENGTH_LONG
            ).show() }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { InputField(label = "Name", isPasswordType = false) }
            item { InputField(label = "Email", isPasswordType = false) }
            item { InputField(label = "Password", isPasswordType = true) }
            item { TermsAgreement() }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { LongButton(backgroundColor = Violet100, textColor = BaseLight80, text = "Sign Up") }
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

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen()
}