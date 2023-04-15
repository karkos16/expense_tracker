package com.example.expensetracker.repos

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    fun getCurrentUser(): FirebaseUser?
    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    )
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    )
    suspend fun signOut()
}