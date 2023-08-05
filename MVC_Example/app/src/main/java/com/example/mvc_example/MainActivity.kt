package com.example.mvc_example

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvc_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

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

        binding.tvMessage.visibility = View.VISIBLE

        if (user.isValidEmail() && user.isValidPassword()) {
            binding.tvMessage.text = "Login Successful"
            binding.tvMessage.setTextColor(Color.GREEN)
        } else {
            binding.tvMessage.text = "Email or Password invalid"
            binding.tvMessage.setTextColor(Color.RED)
        }
    }
}