package com.example.expensetracker.ui.screens.authScreens.authComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.BaseDark100
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight40
import com.example.expensetracker.ui.theme.BaseLight60

@Composable
fun InputField(
    label: String,
    isPasswordType: Boolean,
    value: String,
    onValueChange: (String) -> Unit,
    isError: String?
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        Icons.Default.Visibility
    else
        Icons.Default.VisibilityOff

    val colors = TextFieldDefaults.outlinedTextFieldColors(textColor = BaseDark100, unfocusedBorderColor = BaseLight60, placeholderColor = BaseLight20)

    if (isPasswordType) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            isError = isError != null,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(label) },
            colors = colors,
            trailingIcon = { Icon(
                imageVector = icon,
                contentDescription = "Visibility",
                modifier = Modifier.clickable { passwordVisibility = !passwordVisibility }
                )
            },
            visualTransformation = if (passwordVisibility)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        )
    } else {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(label) },
            colors = colors
        )
    }
}
