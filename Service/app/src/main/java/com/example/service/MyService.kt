package com.example.service

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.e("Tincoder", "MyService onCreate")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val strDataIntent = intent?.getStringExtra("key_data_intent")
        sendNotification(strDataIntent)
        return START_NOT_STICKY
    }

    private fun sendNotification(strDataIntent: String?) {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
            .setContentTitle("Title Notification Service")
            .setContentText(strDataIntent)
            .setSmallIcon(R.drawable.baseline_add_alert_24)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Tincoder", "MyService onDestroy")
    }
}