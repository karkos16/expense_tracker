package com.example.expensetracker.domain.useCase


class ValidateTerms {

    fun execute(acceptedTerms: Boolean): ValidationReslut {
        if (!acceptedTerms) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }
        return ValidationReslut(
            successful = true
        )
    }
}