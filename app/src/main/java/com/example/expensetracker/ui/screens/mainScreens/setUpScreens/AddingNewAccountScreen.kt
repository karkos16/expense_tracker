package com.example.expensetracker.ui.screens.mainScreens.setUpScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.onEvents.AddingAccountFormEvent
import com.example.expensetracker.ui.screens.authScreens.authComponents.InputField
import com.example.expensetracker.ui.screens.authScreens.authComponents.TopNavigation
import com.example.expensetracker.ui.screens.mainScreens.homeScreens.components.DropDownField
import com.example.expensetracker.ui.screens.onBoardingScreens.components.LongButton
import com.example.expensetracker.ui.theme.BaseLight100
import com.example.expensetracker.ui.theme.BaseLight40
import com.example.expensetracker.ui.theme.BaseLight80
import com.example.expensetracker.ui.theme.Inter
import com.example.expensetracker.ui.theme.Violet100
import com.example.expensetracker.ui.viewModels.AddingAccountViewModel

@Composable
fun AddingNewAccountScreen(
    viewModel: AddingAccountViewModel = hiltViewModel()
) {
    var expanded by remember {mutableStateOf(false)}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Violet100)) {
        TopNavigation(text = "Add new account", color = BaseLight100) {
//            TODO: Navigation to settingUpScreen
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
            Column {
                Column (modifier = Modifier.padding(15.dp)) {
                    Text(
                        text = "Balance",
                        color = BaseLight40,
                        fontFamily = Inter,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$00.0",
                        color = BaseLight80,
                        fontFamily = Inter,
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(BaseLight100)
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        Spacer(Modifier.height(24.dp))
                        InputField(
                            label = "Name",
                            isPasswordType = false,
                            value = viewModel.state.name,
                            onValueChange = {viewModel.onEvent(AddingAccountFormEvent.NameChanged(it))}
                        )

                        DropDownField()

                        Spacer(modifier = Modifier.height(32.dp))
                        LongButton(backgroundColor = Violet100, textColor = BaseLight80, text = "Contiune") {
                            viewModel.onEvent(AddingAccountFormEvent.Submit)
//                            TODO: CHECK IF SUCCESS AND THEN NAVIGATE TO MAIN SCREEN
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun AddingNewAccoutScreenPreview() {
    AddingNewAccountScreen()
}