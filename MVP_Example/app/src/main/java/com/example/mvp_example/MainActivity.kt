package com.example.mvp_example

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvp_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginInterface {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val loginPresenter: LoginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            clickLogin()
        }
    }

    private fun clickLogin() {
        val strEmail = binding.edtEmail.text.toString().trim()
        val strPassword = binding.edtPassword.text.toString().trim()

        val user = User(strEmail, strPassword)
        loginPresenter.login(user)
    }

    override fun loginSuccess() {
        binding.tvMessage.visibility = View.VISIBLE
        binding.tvMessage.text = "Login Successed"
        binding.tvMessage.setTextColor(Color.GREEN)
    }

    override fun loginError() {
        binding.tvMessage.visibility = View.VISIBLE
        binding.tvMessage.text = "Login failed"
        binding.tvMessage.setTextColor(Color.RED)
    }
}