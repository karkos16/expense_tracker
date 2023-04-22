package com.example.expensetracker.di

import com.example.expensetracker.domain.useCase.ValidateEmail
import com.example.expensetracker.domain.useCase.ValidateName
import com.example.expensetracker.domain.useCase.ValidatePassword
import com.example.expensetracker.domain.useCase.ValidateTerms
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ValidateModule {

    @Provides
    fun provideEmailValidator(): ValidateEmail {
        return ValidateEmail()
    }

    @Provides
    fun providePasswordValidator(): ValidatePassword {
        return ValidatePassword()
    }

    @Provides
    fun provideTermsValidator(): ValidateTerms {
        return ValidateTerms()
    }

    @Provides
    fun provideNameValidator(): ValidateName {
        return ValidateName()
    }
}