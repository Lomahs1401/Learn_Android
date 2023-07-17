package com.example.notificationexample

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            .setContentTitle(TITLE_PUSH_NOTIFICATION)
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigTextStyle().bigText(CONTENT_PUSH_NOTIFICATION))
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
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sad_anime_girl)

        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_2)
            .setContentTitle("Title push notification 2")
            .setContentText("This is a push notification 2")
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setColor(resources.getColor(R.color.purple_700))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(getNotificationId(), notification)
    }

    private fun getNotificationId() = Date().time.toInt()

    companion object {
        const val TITLE_PUSH_NOTIFICATION = "Mèo đã được thuần hóa từ khoảng 9.000 năm trước và trở thành một trong những thú cưng phổ biến nhất trên thế giới."
        const val CONTENT_PUSH_NOTIFICATION = "Chúng thích nằm ở những nơi ấm áp và cao hơn. Điều này xuất phát từ hành vi tự nhiên của mèo trong tự nhiên để bảo vệ khỏi con mồi tiềm năng."
    }
}