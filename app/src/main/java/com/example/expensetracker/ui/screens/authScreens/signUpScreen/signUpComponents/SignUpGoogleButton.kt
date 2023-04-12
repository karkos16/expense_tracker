package com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.BaseDark100
import com.example.expensetracker.ui.theme.BaseLight60

@Composable
fun SignUpGoogleButton(
    onClick: () -> Unit
) {
    val colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        border = BorderStroke(1.dp, BaseLight60)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icons8_google),
                contentDescription = "Google icon"
            )
            Text(
                text = "Sign Up with Google",
                color = BaseDark100,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpGoogleButtonPreview() {
    SignUpGoogleButton({Log.d("KLIK", "KLIK")})
}