package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            clickStartService()
        }

        binding.btnStopService.setOnClickListener {
            clickStopService()
        }
    }

    private fun clickStartService() {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("key_data_intent", binding.etDataIntent.text.toString().trim())
        startService(intent)
    }

    private fun clickStopService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }
}