package com.example.expensetracker.ui.viewModels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.expensetracker.ui.onEvents.AddingAccountFormEvent
import com.example.expensetracker.ui.viewModels.states.AddingAccountFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddingAccountViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(AddingAccountFormState())

    fun onEvent(event: AddingAccountFormEvent) {
        when (event) {
            is AddingAccountFormEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }
            is AddingAccountFormEvent.TypeChanged -> {
                state = state.copy(accountType = event.type)
            }
            is AddingAccountFormEvent.Submit -> {
//                TODO: Submit adding account
            }
        }
    }
}