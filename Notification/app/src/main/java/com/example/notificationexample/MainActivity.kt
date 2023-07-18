package com.example.notificationexample

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationexample.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSendNotificationLow.setOnClickListener {
            sendNotificationLow()
        }

        binding.btnSendNotificationMedium.setOnClickListener {
            sendNotificationMedium()
        }

        binding.btnSendNotificationHigh.setOnClickListener {
            sendNotificationHigh()
        }

        binding.btnCustomNotification.setOnClickListener {
            sendCustomNotification()
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotificationLow() {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_LOW)
            .setContentTitle(TITLE_PUSH_NOTIFICATION)
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigTextStyle().bigText(CONTENT_PUSH_NOTIFICATION))
            .setColor(resources.getColor(R.color.purple_700))
            .setSound(uri)
            .build()

//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(getNotificationId(), notification)

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(getNotificationId(), notification)
    }

    @SuppressLint("MissingPermission")
    private fun sendNotificationMedium() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sad_anime_girl)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_MEDIUM)
            .setContentTitle("Title push notification Medium")
            .setContentText("This is a push notification Medium")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setColor(resources.getColor(R.color.purple_700))
            .setSound(uri)
            .build()

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(getNotificationId(), notification)
    }

    @SuppressLint("MissingPermission")
    private fun sendNotificationHigh() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sad_anime_girl)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_HIGH)
            .setContentTitle("Title push notification High")
            .setContentText("This is a push notification High")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setColor(resources.getColor(R.color.purple_700))
            .setSound(uri)
            .build()

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(getNotificationId(), notification)
    }

    @SuppressLint("SimpleDateFormat")
    private fun sendCustomNotification() {
        val customSound = Uri.parse("android.resource://" + packageName + "/" + R.raw.sound_notification_custom)

        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val strDate = simpleDateFormat.format(Date())

        // Collapsed
        val notificationCollapsedLayout = RemoteViews(packageName, R.layout.layout_custom_notification).apply {
            setTextViewText(R.id.tv_title_custom_notification, "Title Custom Notification")
            setTextViewText(R.id.tv_message_custom_notification, "Message Custom Notification")
            setTextViewText(R.id.tv_time_custom_notification, strDate)
        }

        // Expanded
        val notificationLayoutExpanded = RemoteViews(packageName, R.layout.layout_custom_notification_expanded).apply {
            setTextViewText(R.id.tv_title_custom_notification_expanded, "Title Custom Notification Expanded")
            setTextViewText(R.id.tv_message_custom_notification_expanded, "Message Custom Notification Expanded")
            setImageViewResource(R.id.img_custom_notification_expanded, R.drawable.sad_anime_girl)
        }

        val notificationExpanded = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_CUSTOM)
            .setSmallIcon(R.drawable.ic_music_play)
            .setCustomContentView(notificationCollapsedLayout)
            .setCustomBigContentView(notificationLayoutExpanded)
            .setSound(customSound)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(getNotificationId(), notificationExpanded)
    }

    private fun getNotificationId() = Date().time.toInt()

    companion object {
        const val TITLE_PUSH_NOTIFICATION = "Mèo đã được thuần hóa từ khoảng 9.000 năm trước và trở thành một trong những thú cưng phổ biến nhất trên thế giới."
        const val CONTENT_PUSH_NOTIFICATION = "Chúng thích nằm ở những nơi ấm áp và cao hơn. Điều này xuất phát từ hành vi tự nhiên của mèo trong tự nhiên để bảo vệ khỏi con mồi tiềm năng."
    }
}