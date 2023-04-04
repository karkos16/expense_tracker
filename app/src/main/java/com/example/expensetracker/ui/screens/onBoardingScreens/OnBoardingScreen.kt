package com.example.expensetracker.ui.screens.onBoardingScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.screens.onBoardingScreens.components.ImageWithDescription
import com.example.expensetracker.ui.screens.onBoardingScreens.components.LongButton
import com.example.expensetracker.ui.theme.*

@Composable
fun OnBoardingScreen() {
    val context = LocalContext.current
    val imageID = context.resources.getIdentifier("money", "drawable", context.packageName)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ImageWithDescription(
            imageID = imageID,
            bigText = "Gain total control of your money",
            smallText = "Become your own money manager and make every cent count"
        )
        LongButton(backgroundColor = Violet100, textColor = Violet80, text = "Sign Up")
        LongButton(backgroundColor = Violet20, textColor = Violet100, text = "Login")
    }
}

@Composable
@Preview
fun OnBouardingScreenPreview() {
    OnBoardingScreen()
}
