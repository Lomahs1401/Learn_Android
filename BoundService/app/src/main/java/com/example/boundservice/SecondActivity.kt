package com.example.boundservice

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import com.example.boundservice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private var messenger: Messenger? = null
    private var isServiceConnected = false

    private var serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName?, iBinder: IBinder?) {
            messenger = Messenger(iBinder)
            isServiceConnected = true

            // Send message to play music
            sendMessagePlayMusic()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            messenger = null
            isServiceConnected = false
        }
    }

    private fun sendMessagePlayMusic() {
        val message = Message.obtain(null, MusicBoundServiceMessenger.MSG_PLAY_MUSIC, 0, 0)
        try {
            messenger?.send(message)
        } catch (e: Exception) {
            e.printStackTrace()
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
        val intent = Intent(this, MusicBoundServiceMessenger::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun onClickStopBoundService() {
        if (isServiceConnected) {
            unbindService(serviceConnection)
            isServiceConnected = false
        }
    }
}