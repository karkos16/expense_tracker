package com.example.expensetracker.ui.screens.mainScreens.setUpScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.screens.onBoardingScreens.components.LongButton
import com.example.expensetracker.ui.theme.BaseDark25
import com.example.expensetracker.ui.theme.BaseDark50
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Inter
import com.example.expensetracker.ui.theme.Violet100

@Composable
fun SettingUpScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(67.dp))
        Box(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Let's setup your accont!",
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
                color = BaseDark50
            )
        }
        Box(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 83.dp, bottom = 16.dp)) {
            Text(
                text = "Account can be your bank account or your wallet.",
                fontFamily = Inter,
                fontSize = 14.sp,
                color = BaseDark25
            )
        }

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        LongButton(backgroundColor = Violet100, textColor = BaseLight80, text = "Let's go") {
//            TODO: navigation to AddingNewAccountScreen
        }
    }

}

@Composable
@Preview(showBackground = true)
fun SettingUpScreenPreview() {
    SettingUpScreen()
}