package com.example.boundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MusicBoundService : Service() {

    private var binder: MyBinder = MyBinder()
    private var mediaPlayer: MediaPlayer? = null
    inner class MyBinder : Binder() {
        fun getMusicBoundService(): MusicBoundService {
            return this@MusicBoundService
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("MusicBoundService", "onBind")
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("MusicBoundService", "onCreate")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("MusicBoundService", "onUnbind")
        mediaPlayer?.release()
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MusicBoundService", "onDestroy")
        if (mediaPlayer != null) {
            mediaPlayer?.release()
        }
    }

    fun startMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilac)
        }
        mediaPlayer?.start()
    }
}