package com.example.expensetracker.domain.useCase

class ValidateName {

    fun execute(name: String): ValidationReslut {
        if (name.isBlank()) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Name field cannot be empty!"
            )
        }
        val nameRegex = Regex("[a-zA-Z ]+")
        if(!nameRegex.matches(name)) {
            return ValidationReslut(
                successful = false,
                errorMessage = "Name can only contain letters and spaces"
            )
        }
        return ValidationReslut(
            successful = true
        )
    }
}