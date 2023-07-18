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
            val customSound = Uri.parse("android.resource://" + packageName + "/" + R.raw.sound_notification_custom)
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                .build()

            // Config channel 1 (IMPORTANCE LOW)
            val nameImportanceLow = getString(R.string.channel_name_low)
            val descriptionTextImportanceLow = getString(R.string.channel_description_low)
            val importanceLow = NotificationManager.IMPORTANCE_MIN
            val channelLow = NotificationChannel(CHANNEL_ID_LOW, nameImportanceLow, importanceLow).apply {
                description = descriptionTextImportanceLow
                setSound(uri, audioAttributes)
            }

            // Config channel 2 (IMPORTANCE MEDIUM)
            val nameImportanceMedium = getString(R.string.channel_name_medium)
            val descriptionTextMedium = getString(R.string.channel_description_medium)
            val importanceMedium = NotificationManager.IMPORTANCE_DEFAULT
            val channelMedium = NotificationChannel(CHANNEL_ID_MEDIUM, nameImportanceMedium, importanceMedium).apply {
                description = descriptionTextMedium
                setSound(uri, audioAttributes)
            }

            // Config channel 3 (IMPORTANCE HIGH)
            val nameImportanceHigh = getString(R.string.channel_name_high)
            val descriptionTextHigh = getString(R.string.channel_description_high)
            val importanceHigh = NotificationManager.IMPORTANCE_HIGH
            val channelHigh = NotificationChannel(CHANNEL_ID_HIGH, nameImportanceHigh, importanceHigh).apply {
                description = descriptionTextHigh
                setSound(uri, audioAttributes)
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
            notificationManager.createNotificationChannel(channelLow)
            notificationManager.createNotificationChannel(channelMedium)
            notificationManager.createNotificationChannel(channelHigh)
            notificationManager.createNotificationChannel(channelCustomNotification)
        }
    }

    companion object {
        const val CHANNEL_ID_LOW = "CHANNEL_LOW"
        const val CHANNEL_ID_MEDIUM = "CHANNEL_MEDIUM"
        const val CHANNEL_ID_HIGH = "CHANNEL_HIGH"
        const val CHANNEL_ID_CUSTOM = "CHANNEL_CUSTOM"
    }
}