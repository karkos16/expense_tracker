package com.example.expensetracker.ui.screens.onBoardingScreens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.theme.*

@Composable
fun ImageWithDescription(imageID: Int, bigText: String = "Test", smallText: String = "Test") {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(start = 31.dp, top = 52.dp)
                .width(312.dp)
                .height(312.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
        Box(modifier = Modifier
            .padding(
                start = 49.dp,
                top = 41.dp,
                end = 49.dp,
                bottom = 31.dp
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = bigText,
                    modifier = Modifier.padding(bottom = 17.dp),
                    textAlign = TextAlign.Center,
                    color = BigTextColor,
                    fontSize = 32.sp
                )
                Text(
                    text = smallText,
                    textAlign = TextAlign.Center,
                    color = SmallTextColor,
                    fontSize = 19.sp
                )
            }
        }
    }
}