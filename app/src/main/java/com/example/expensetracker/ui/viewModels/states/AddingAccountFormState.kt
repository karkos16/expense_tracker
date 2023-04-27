package com.example.expensetracker.ui.viewModels.states

data class AddingAccountFormState(
    val balance: Float = 0.0f,
    val name: String = "",
    val accountType: AccountType? = null
)

sealed class AccountType {
    object Bank: AccountType()
    object Wallet: AccountType()
}
