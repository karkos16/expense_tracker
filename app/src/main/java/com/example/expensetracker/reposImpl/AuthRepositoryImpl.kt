package com.example.expensetracker.reposImpl

import android.util.Log
import com.example.expensetracker.repos.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {
    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String) {
        try {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AUTH", "createUserWithEmail:success")
                    } else {
                        Log.d("AUTH", "createUserWithEmail:failure")
                    }
                }
        } catch (e:Exception) {
            Log.d("AUTH", e.message.toString())
        }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        try {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AUTH", "signInUserWithEmail:success")
                    } else {
                        Log.d("AUTH", "signInUserWithEmail:failure")
                    }
                }
        } catch (e:Exception) {
            Log.d("AUTH", e.message.toString())
        }
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }
}