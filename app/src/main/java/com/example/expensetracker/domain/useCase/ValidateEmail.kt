package com.example.expensetracker.domain.useCase

import android.util.Patterns

class ValidateEmail {

    fun execute(email: String): ValidationReslut {
        if (email.isBlank()) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Email field cannot be empty!"
            )
        }
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        if(!emailRegex.matches(email)) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Email doesn't match email pattern"
            )
        }
        return ValidationReslut(
            successful = true
        )
    }
}