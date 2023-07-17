package com.example.notificationexample

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val customSound =
                Uri.parse("android.resource://" + packageName + "/" + R.raw.sound_notification_custom)
            val audioAttributes: AudioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                .build()

            // Config channel 1
            val name1 = getString(R.string.channel_name_1)
            val descriptionText1 = getString(R.string.channel_description_1)
            val importance1 = NotificationManager.IMPORTANCE_MIN
            val channel1 = NotificationChannel(CHANNEL_ID_1, name1, importance1).apply {
                description = descriptionText1
                setSound(uri, audioAttributes)
            }

            // Config channel 2
            val name2 = getString(R.string.channel_name_2)
            val descriptionText2 = getString(R.string.channel_description_2)
            val importance2 = NotificationManager.IMPORTANCE_HIGH
            val channel2 = NotificationChannel(CHANNEL_ID_2, name2, importance2).apply {
                description = descriptionText2
                setSound(customSound, audioAttributes)
            }

            // Config channel custom notification
            val nameCustomNotification = getString(R.string.channel_name_custom_notification)
            val descriptionCustomNotification =
                getString(R.string.channel_description_custom_notification)
            val importanceCustomNotification = NotificationManager.IMPORTANCE_HIGH
            val channelCustomNotification = NotificationChannel(
                CHANNEL_ID_CUSTOM,
                nameCustomNotification,
                importanceCustomNotification
            ).apply {
                description = descriptionCustomNotification
                setSound(customSound, audioAttributes)
            }

            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
            notificationManager.createNotificationChannel(channelCustomNotification)
        }
    }

    companion object {
        const val CHANNEL_ID_1 = "CHANNEL_1"
        const val CHANNEL_ID_2 = "CHANNEL_2"
        const val CHANNEL_ID_CUSTOM = "CHANNEL_CUSTOM"
    }
}