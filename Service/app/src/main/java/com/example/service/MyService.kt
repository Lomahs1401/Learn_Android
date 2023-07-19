package com.example.service

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyService : Service() {

    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private var isPlaying: Boolean = false
    private var mSong: Song? = null

    override fun onCreate() {
        super.onCreate()
        Log.e("Tincoder", "MyService onCreate")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val bundle = intent?.extras
        if (bundle != null) {
            val song = bundle.get("object_song") as? Song
            if (song != null) {
                mSong = song
                startMusic(song)
                sendNotificationMedia(song)
            }
        }

        val actionMusic = intent?.getIntExtra("action_music_service", 0)
        if (actionMusic != null) {
            handleActionMusic(actionMusic)
        }

        return START_NOT_STICKY
    }

    private fun startMusic(song: Song) {
        mediaPlayer = MediaPlayer.create(applicationContext, song.resource)
        mediaPlayer.start().let {
            isPlaying = true
        }
        sendActionToActivity(ACTION_START)
    }

    private fun handleActionMusic(action: Int) {
        when (action) {
            ACTION_PAUSE -> pauseMusic()
            ACTION_RESUME -> resumeMusic()
            ACTION_CLEAR -> {
                stopSelf()
                sendActionToActivity(ACTION_CLEAR)
            }
        }
    }

    private fun pauseMusic() {
        if (isPlaying) {
            mediaPlayer.pause().let {
                isPlaying = false
                mSong?.let { song ->
                    sendNotificationMedia(song)
                    sendActionToActivity(ACTION_PAUSE)
                }
            }
        }
    }

    private fun resumeMusic() {
        if (!isPlaying) {
            mediaPlayer.start().let {
                isPlaying = true
                mSong?.let { song ->
                    sendNotificationMedia(song)
                    sendActionToActivity(ACTION_RESUME)
                }
            }
        }
    }

//    private fun sendNotification(song: Song) {
//        val intent = Intent(this, MainActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(
//            this, 0, intent,
//            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//        )
//
//        val bitmap = BitmapFactory.decodeResource(resources, song.image)
//
//        val remoteViews = RemoteViews(packageName, R.layout.layout_custom_notification).apply {
//            setTextViewText(R.id.tv_title_song, song.title)
//            setTextViewText(R.id.tv_singer_song, song.singer)
//            setImageViewBitmap(R.id.img_song, bitmap)
//            setImageViewResource(R.id.img_play_or_pause, R.drawable.play_circle_48px)
//            setImageViewResource(R.id.img_clear, R.drawable.close_48px)
//        }
//
//        if (isPlaying) {
//            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_PAUSE))
//            remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.pause_circle_48px)
//        } else {
//            remoteViews.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_RESUME))
//            remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.play_circle_48px)
//        }
//
//        remoteViews.setOnClickPendingIntent(R.id.img_clear, getPendingIntent(this, ACTION_CLEAR))
//
//        val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
//            .setSmallIcon(R.drawable.baseline_add_alert_24)
//            .setContentIntent(pendingIntent)
//            .setCustomContentView(remoteViews)
//            .setSound(null)
//            .build()
//
//        startForeground(1, notification)
//    }

    private fun sendNotificationMedia(song: Song) {
        val bitmap = BitmapFactory.decodeResource(resources, song.image)

        // Create a MediaSessionCompat
        val mediaSessionCompat = MediaSessionCompat(this, "Tag")

        val mediaMetadata = MediaMetadataCompat.Builder()
            .putString(MediaMetadataCompat.METADATA_KEY_TITLE, song.title)
            .putString(MediaMetadataCompat.METADATA_KEY_ARTIST, song.singer)
            .build()

        // Đặt Metadata vào MediaSessionCompat
        mediaSessionCompat.setMetadata(mediaMetadata)
        mediaSessionCompat.isActive = true

        val notificationBuilder = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
            // Show controls on lock screen even when user hides sensitive content.
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(R.drawable.ic_music_play)
            .setLargeIcon(bitmap)
            .setSubText("Test")
            .setContentTitle(song.title)
            .setContentText(song.singer)

            // Apply the media style template
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle()
                .setShowActionsInCompactView(3)
                .setMediaSession(mediaSessionCompat.sessionToken))

        if (isPlaying) {
            notificationBuilder
                // Add media control buttons that invoke intents in your media service
                .addAction(R.drawable.baseline_skip_previous_24, "Previous", null) // #0
                .addAction(R.drawable.baseline_pause_24, "Pause", getPendingIntent(this, ACTION_PAUSE)) // #1
                .addAction(R.drawable.baseline_skip_next_24, "Next", null) // #2
                .addAction(R.drawable.close_48px, "Clear", getPendingIntent(this, ACTION_CLEAR)) // #3
        } else {
            notificationBuilder
                // Add media control buttons that invoke intents in your media service
                .addAction(R.drawable.baseline_skip_previous_24, "Previous", null) // #0
                .addAction(R.drawable.play_circle_48px, "Resume", getPendingIntent(this, ACTION_RESUME)) // #1
                .addAction(R.drawable.baseline_skip_next_24, "Next", null) // #2
                .addAction(R.drawable.close_48px, "Clear", getPendingIntent(this, ACTION_CLEAR)) // #3
        }

        startForeground(1, notificationBuilder.build())
    }

    private fun getPendingIntent(context: Context, action: Int): PendingIntent {
        val intent = Intent(this, MyReceiver::class.java)
        intent.putExtra("action_music", action)
        return PendingIntent.getBroadcast(context.applicationContext, action, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Tincoder", "MyService onDestroy")
        mediaPlayer.release()
    }

    private fun sendActionToActivity(action: Int) {
        val intent = Intent("send_data_to_activity")
        val bundle = Bundle()
        bundle.putSerializable("object_song", mSong)
        bundle.putBoolean("status_player", isPlaying)
        bundle.putInt("action_music", action)

        intent.putExtras(bundle)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    companion object {
        const val ACTION_PAUSE = 1
        const val ACTION_RESUME = 2
        const val ACTION_CLEAR = 3
        const val ACTION_START = 4
    }
}