package com.example.expensetracker.ui.screens.authScreens.signUpScreen.signUpComponents

import android.text.BoringLayout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.Violet100

@Composable
fun TermsAgreement(
    checkState: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val agreementText = "By signing up, you agree to the Terms of Service and Privacy Policy"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 26.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkState,
            onCheckedChange = onCheckedChange,
            enabled = true,
            colors = CheckboxDefaults.colors(uncheckedColor = Violet100)
        )
        Text(text = agreementText, color = Color.Black)
    }
}