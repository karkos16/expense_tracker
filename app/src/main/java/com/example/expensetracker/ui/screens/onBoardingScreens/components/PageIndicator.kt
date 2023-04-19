package com.example.expensetracker.ui.screens.onBoardingScreens.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.Violet100

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(modifier = Modifier
            .padding(bottom = 33.dp)
            .width(64.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pageCount) { iteration ->
                val color = if (currentPage == iteration) Violet100 else Color(0xFFEEE5FF)
                val size = if (currentPage == iteration) 16.dp else 8.dp
                val animatedColor = animateColorAsState(targetValue = color).value
                Box(modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .background(animatedColor)
                )
            }
        }
    }
}

@Composable
@Preview
fun PageIndicatorPreview() {
    PageIndicator(3,1)
}