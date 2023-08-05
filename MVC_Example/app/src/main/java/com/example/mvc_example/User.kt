package com.example.mvc_example

import android.text.TextUtils
import android.util.Patterns

class User(private val email: String, private val password: String) {
    fun isValidEmail(): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(): Boolean {
        return !TextUtils.isEmpty(password) && password.length >= 6
    }
}