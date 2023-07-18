package com.example.notificationexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notificationexample.databinding.ActivityListProductBinding

class ListProductActivity : AppCompatActivity() {
    private val binding: ActivityListProductBinding by lazy {
        ActivityListProductBinding.inflate(layoutInflater)
    }

    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "ListProductActivity"

        binding.btnGoToDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}