package com.example.boundservice

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log

class MusicBoundServiceMessenger : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var messenger: Messenger? = null

    @SuppressLint("HandlerLeak")
    inner class MyHandler(val context: Context) : Handler() {
        override fun handleMessage(msg: Message) {
            when(msg.what) {
                MSG_PLAY_MUSIC -> startMusic()
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("MusicBoundServiceMessenger", "onCreate")
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.e("MusicBoundServiceMessenger", "onBind")
        messenger = Messenger(MyHandler(this))
        return messenger?.binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("MusicBoundServiceMessenger", "onUnbind")
        if (mediaPlayer != null) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e("MusicBoundServiceMessenger", "onDestroy")
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    private fun startMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilac)
        }
        mediaPlayer?.start()
    }

    companion object {
        const val MSG_PLAY_MUSIC = 1
    }
}