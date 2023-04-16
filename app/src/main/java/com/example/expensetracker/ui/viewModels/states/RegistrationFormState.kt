package com.example.expensetracker.ui.viewModels.states

data class RegistrationFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val name: String = "",
    val nameError: String? = null,
    val acceptedTerms: Boolean = false ,
    val termsError: String? = null
)
