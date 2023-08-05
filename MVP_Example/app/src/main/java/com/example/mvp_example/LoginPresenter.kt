package com.example.mvp_example

class LoginPresenter(private val loginInterface: LoginInterface) {
    fun login(user: User) {
        if (user.isValidEmail() && user.isValidPassword()) {
            loginInterface.loginSuccess()
        } else {
            loginInterface.loginError()
        }
    }
}