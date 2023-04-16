package com.example.expensetracker.domain.useCase

data class ValidationReslut(
    val successful: Boolean,
    val errorMessage: String? = null
)
