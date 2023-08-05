package com.example.mvvm_example

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

class LoginViewModel : BaseObservable() {
    @get:Bindable
    var email: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @get:Bindable
    var password: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

    val messageLogin: ObservableField<String> = ObservableField<String>()
    val isShowMessage: ObservableField<Boolean> = ObservableField<Boolean>()
    val isSuccess: ObservableField<Boolean> = ObservableField<Boolean>()

    fun onClickLogin() {
        val user = User(email, password)
        isShowMessage.set(true)
        isSuccess.set(true)

        if (user.isValidEmail() && user.isValidPassword()) {
            messageLogin.set("Login Success")
        } else {
            messageLogin.set("Email or password invalid")
        }
    }
}