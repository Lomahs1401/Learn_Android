package com.example.foregroundserviceandboundsevice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.foregroundserviceandboundsevice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var myService: MyService? = null
    private var isServiceConnected = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName?, ibinder: IBinder?) {
            val myBinder = ibinder as MyService.MyBinder
            myService = myBinder.getMyService()
            isServiceConnected = true
        }

        override fun onServiceDisconnected(componentName: ComponentName?) {
            myService = null
            isServiceConnected = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            onClickStartService()
        }

        binding.btnStopForegroundService.setOnClickListener {
            onClickStopForegroundService()
        }

        binding.btnStopBoundService.setOnClickListener {
            onClickStopBoundService()
        }
    }

    private fun onClickStartService() {
        val intent = Intent(this, MyService::class.java)
        startService(intent)

        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun onClickStopForegroundService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }

    private fun onClickStopBoundService() {
        if (isServiceConnected) {
            unbindService(serviceConnection)
            isServiceConnected = false
        }
    }
}