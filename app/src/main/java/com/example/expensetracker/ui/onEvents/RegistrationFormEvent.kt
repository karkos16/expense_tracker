package com.example.expensetracker.ui.onEvents

sealed class RegistrationFormEvent {
    data class EmailChanged(val email: String): RegistrationFormEvent()
    data class PasswordChanged(val password: String): RegistrationFormEvent()
    data class NameChanged(val name: String): RegistrationFormEvent()
    data class AcceptTerms(val isAccepted: Boolean): RegistrationFormEvent()

    object Submit: RegistrationFormEvent()
}
