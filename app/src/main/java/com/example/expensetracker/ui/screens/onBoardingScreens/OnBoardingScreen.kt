package com.example.expensetracker.ui.screens.onBoardingScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.screens.onBoardingScreens.components.ImageWithDescription
import com.example.expensetracker.ui.screens.onBoardingScreens.components.LongButton
import com.example.expensetracker.ui.screens.onBoardingScreens.components.PageIndicator
import com.example.expensetracker.ui.theme.*

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    val context = LocalContext.current
    val images = listOf(
        listOf<Any>(
            context.resources.getIdentifier("money", "drawable", context.packageName),
            "Gain total control of your money",
            "Become your own money manager and make every cent count"
        ),
        listOf<Any>(
            context.resources.getIdentifier("money_go", "drawable", context.packageName),
            "Know where your money goes",
            "Track your transaction easily, with categories and financial report"
        ),
        listOf<Any>(
            context.resources.getIdentifier("planing", "drawable", context.packageName),
            "Planing ahead",
            "Setup your budget for each category so you in control"
        )
    )
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            pageCount = images.size,
            state = pagerState
        ) {pageIndex ->
            ImageWithDescription(
                imageID = images[pageIndex][0] as Int,
                bigText = images[pageIndex][1] as String,
                smallText = images[pageIndex][2] as String
            )
        }
        PageIndicator(pageCount = images.size, currentPage = pagerState.currentPage)
        LongButton(backgroundColor = Violet100, textColor = Violet80, text = "Sign Up")
        LongButton(backgroundColor = Violet20, textColor = Violet100, text = "Login")
    }
}

@Composable
@Preview
fun OnBouardingScreenPreview() {
    OnBoardingScreen()
}
