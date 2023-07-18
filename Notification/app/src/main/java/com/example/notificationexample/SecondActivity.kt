package com.example.notificationexample

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationexample.databinding.ActivitySecondBinding
import java.util.*

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "SecondActivity"

        binding.btnSendNotification.setOnClickListener {
            sendPushNotification()
        }

        binding.btnGoToListProduct.setOnClickListener {
            val intent = Intent(this, ListProductActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendPushNotification() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sad_anime_girl)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // --------------------------------- REGULAR ACTIVITY -----------------------------------

        // Create an Intent for the activity you want to start
        val resultIntent = Intent(this, DetailActivity::class.java)
        // Create the TaskStackBuilder
        val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            // Add the intent, which inflates the back stack
            addNextIntentWithParentStack(resultIntent)
            // Get the PendingIntent containing the entire back stack
            getPendingIntent(
                getNotificationId(),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }

        // --------------------------------- SPECIAL ACTIVITY -----------------------------------

        val notifyIntent = Intent(this, DetailActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val notifyPendingIntent = PendingIntent.getActivity(
            this, getNotificationId(), notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_MEDIUM)
            .setContentTitle("Title push notification Medium")
            .setContentText("This is a push notification Medium")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setColor(resources.getColor(R.color.purple_700))
            .setSound(uri)
            .setContentIntent(notifyPendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(getNotificationId(), notification)
    }

    private fun getNotificationId() = Date().time.toInt()
}