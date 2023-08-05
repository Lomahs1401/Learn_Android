package com.example.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.boundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var musicBoundService = MusicBoundService()
    private var isServiceConnected = false

    // Xác định callbacks cho service được bind tới, sẽ được truyền vào bindService()
    private var serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName?, iBinder: IBinder?) {
            // Đã bind thành công tới MusicBoundService, cast IBinder và lấy MusicBoundService instance
            val myBinder = iBinder as MusicBoundService.MyBinder
            musicBoundService = myBinder.getMusicBoundService()
            musicBoundService.startMusic()
            isServiceConnected = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isServiceConnected = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            onClickStartBoundService()
        }

        binding.btnStopService.setOnClickListener {
            onClickStopBoundService()
        }
    }

    private fun onClickStartBoundService() {
        val intent = Intent(this, MusicBoundService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun onClickStopBoundService() {
        if (isServiceConnected) {
            unbindService(serviceConnection)
            isServiceConnected = false
        }
    }
}