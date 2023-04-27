package com.example.expensetracker.ui.screens.mainScreens.homeScreens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.BaseDark100
import com.example.expensetracker.ui.theme.BaseDark25
import com.example.expensetracker.ui.theme.BaseLight20
import com.example.expensetracker.ui.theme.BaseLight60

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownField() {
    val accountType = arrayOf("Cash", "Bank")
    var expanded by remember { mutableStateOf(false)}
    var selectedType by remember { mutableStateOf("")}

    var icon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    val colors = TextFieldDefaults.outlinedTextFieldColors(textColor = BaseDark100, unfocusedBorderColor = BaseLight60, placeholderColor = BaseLight20)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        OutlinedTextField(
            value = selectedType,
            placeholder = { Text("Account Type") },
            onValueChange = { selectedType = it },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = colors,
            trailingIcon = { Icon(icon,"dropdown arrow", Modifier.clickable { expanded = !expanded }) },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            accountType.forEach {type ->
                DropdownMenuItem(onClick = {
                    selectedType = type
                    expanded = false
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = selectedType)
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun DropDownFieldPreview() {
    DropDownField()
}