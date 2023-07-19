package com.example.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.KeyEvent

class MediaButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_MEDIA_BUTTON == intent?.action) {
            val event = intent.getParcelableExtra<KeyEvent>(Intent.EXTRA_KEY_EVENT)
            if (event?.action == KeyEvent.ACTION_DOWN) {
                when (event.keyCode) {
                    KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> {
                        // Xử lý hành động Play/Pause ở đây
                    }
                    KeyEvent.KEYCODE_MEDIA_NEXT -> {
                        // Xử lý hành động Next ở đây
                    }
                    KeyEvent.KEYCODE_MEDIA_PREVIOUS -> {
                        // Xử lý hành động Previous ở đây
                    }
                    // Các hành động khác tùy ý bạn bổ sung
                }
            }
        }
    }
}