package com.example.expensetracker.domain.useCase

import android.util.Patterns

class ValidatePassword {

    fun execute(password: String): ValidationReslut {
        if (password.length < 8) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Password is too short"
            )
        }
        return ValidationReslut(
            successful = true
        )
    }
}