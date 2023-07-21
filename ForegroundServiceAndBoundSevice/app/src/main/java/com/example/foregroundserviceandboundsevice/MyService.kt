package com.example.foregroundserviceandboundsevice

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyService : Service() {

    private val myBinder = MyBinder()

    inner class MyBinder : Binder() {
        fun getMyService() = this@MyService
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.e("MyService", "onBind")
        return myBinder
    }

    override fun onCreate() {
        Log.e("MyService", "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("MyService", "onStartCommand")
        sendNotification()
        return START_NOT_STICKY
    }

    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID).apply {
            setContentTitle(getString(R.string.app_name))
            setContentText("Test service")
            setSmallIcon(R.drawable.ic_launcher_foreground)
        }

        val notification = builder.build()
        startForeground(1, notification)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e("MyService", "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e("MyService", "onDestroy")
        super.onDestroy()
    }
}