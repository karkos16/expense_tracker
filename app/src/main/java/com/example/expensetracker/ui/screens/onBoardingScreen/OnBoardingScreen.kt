package com.example.expensetracker.ui.screens.onBoardingScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.screens.destinations.LoginScreenDestination
import com.example.expensetracker.ui.screens.destinations.SignUpScreenDestination
import com.example.expensetracker.ui.screens.onBoardingScreen.components.ImageWithDescription
import com.example.expensetracker.ui.screens.onBoardingScreen.components.LongButton
import com.example.expensetracker.ui.screens.onBoardingScreen.components.PageIndicator
import com.example.expensetracker.ui.theme.*
import com.example.expensetracker.ui.viewModels.OnBoardingViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val images = viewModel.getImageIds()
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
        LongButton(
            backgroundColor = Violet100,
            textColor = BaseLight80,
            text = "Sign Up"
        ) { navigator.navigate(SignUpScreenDestination()) }
        LongButton(
            backgroundColor = Violet20,
            textColor = Violet100,
            text = "Login"
        ) { navigator.navigate(LoginScreenDestination()) }
    }
}
