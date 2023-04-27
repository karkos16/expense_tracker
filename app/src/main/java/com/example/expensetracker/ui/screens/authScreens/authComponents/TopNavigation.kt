package com.example.expensetracker.ui.screens.authScreens.authComponents

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopNavigation(
    text: String,
    color: Color,
    onClickNavigation: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(64.dp)
        .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = onClickNavigation,
            modifier = Modifier
                .fillMaxHeight()
                .width(32.dp)
                .align(
                    Alignment.CenterStart
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back arrow",
                tint = color
            )
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            color = color
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TopNavigationPreview() {
    TopNavigation(text = "Sign Up",color = Color.Black , { Log.d("KLIK", "wroc") } )
}