package com.example.expensetracker.ui.screens.onBoardingScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RadialGradient
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.screens.destinations.HomeScreenDestination
import com.example.expensetracker.ui.screens.destinations.OnBoardingScreenDestination
import com.example.expensetracker.ui.theme.BaseLight100
import com.example.expensetracker.ui.theme.BaseYellow100
import com.example.expensetracker.ui.theme.Inter
import com.example.expensetracker.ui.theme.Violet100
import com.example.expensetracker.ui.viewModels.OnLoadingViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RootNavGraph(start = true)
@Destination
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OnLoadingScreen(
    viewModel: OnLoadingViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Violet100),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(start = 100.dp, top = 10.dp)) {
            Box(modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(BaseYellow100, Violet100),
                        center = Offset.Unspecified,
                        radius = 150f,
                        tileMode = TileMode.Decal
                    )
                )
            )
        }

        Text(
            text = "montra",
            color = BaseLight100,
            fontSize = 56.sp,
            textAlign = TextAlign.Center,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold
        )
    }

    if (viewModel.isUserLoggedIn()) {
        coroutineScope.launch {
            delay(3000)
            navigator.navigate(HomeScreenDestination) {popUpTo(HomeScreenDestination.route)}
        }
    } else {
        coroutineScope.launch {
            delay(3000)
            navigator.navigate(OnBoardingScreenDestination) {popUpTo(OnBoardingScreenDestination.route)}
        }
    }
}