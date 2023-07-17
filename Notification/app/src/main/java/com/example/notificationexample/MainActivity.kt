package com.example.notificationexample

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationexample.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSendNotification1.setOnClickListener {
            sendNotification1()
        }

        binding.btnSendNotification2.setOnClickListener {
            sendNotification2()
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification1() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_1)
            .setContentTitle("Title push notification 1")
            .setContentText("This is a push notification 1")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setColor(resources.getColor(R.color.purple_700))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(getNotificationId(), notification)

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(getNotificationId(), notification)
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification2() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_2)
            .setContentTitle("Title push notification 2")
            .setContentText("This is a push notification 2")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setColor(resources.getColor(R.color.purple_700))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(getNotificationId(), notification)
    }

    private fun getNotificationId() = Date().time.toInt()
}