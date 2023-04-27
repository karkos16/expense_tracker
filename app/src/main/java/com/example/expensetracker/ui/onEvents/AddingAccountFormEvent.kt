package com.example.expensetracker.ui.onEvents

import com.example.expensetracker.ui.viewModels.states.AccountType
import com.example.expensetracker.ui.viewModels.states.AddingAccountFormState

sealed class AddingAccountFormEvent {

    data class NameChanged(val name: String): AddingAccountFormEvent()
    data class TypeChanged(val type: AccountType): AddingAccountFormEvent()

    object Submit: AddingAccountFormEvent()
}
