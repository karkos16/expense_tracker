package com.example.expensetracker.ui.screens.onBoardingScreen.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LongButton(
    backgroundColor: Color,
    textColor: Color,
    text: String
//    onClickAction: Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 12.dp, end = 12.dp, bottom = 16.dp)
        .height(56.dp)
    ) {
        Button(
            modifier = Modifier
                .fillMaxSize(),
            onClick = { Log.d("KLIK", "KLIK") },
            content = { Text(text = text, textAlign = TextAlign.Center, fontSize = 18.sp)},
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor, contentColor = textColor),
            shape = RoundedCornerShape(16.dp)
        )
    }
}