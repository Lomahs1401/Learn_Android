package com.example.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val bundle = intent?.extras ?: return
            song = bundle.get("object_song") as? Song
            isPlaying = bundle.getBoolean("status_player")
            val actionMusic = bundle.getInt("action_music")

            handleLayoutMusic(actionMusic)
        }
    }

    private var song: Song? = null
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(broadcastReceiver, IntentFilter("send_data_to_activity"))

        binding.btnStartService.setOnClickListener {
            clickStartService()
        }

        binding.btnStopService.setOnClickListener {
            clickStopService()
        }

    }

    private fun clickStartService() {
        song = Song("Lilac", "Minami", R.drawable.rairakku, R.raw.lilac)

        val intent = Intent(this, MyService::class.java)
        val bundle = Bundle().apply {
            putSerializable("object_song", song)
        }
        intent.putExtras(bundle)

        startService(intent)
    }

    private fun clickStopService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }

    private fun handleLayoutMusic(action: Int) {
        when (action) {
            MyService.ACTION_START -> {
                binding.layoutBottom.visibility = View.VISIBLE
                showInfoSong()
                setStatusButtonPlayOrPause()
            }
            MyService.ACTION_PAUSE -> setStatusButtonPlayOrPause()
            MyService.ACTION_RESUME -> setStatusButtonPlayOrPause()
            MyService.ACTION_CLEAR -> binding.layoutBottom.visibility = View.GONE
        }
    }

    private fun showInfoSong() {

        song?.let {
            binding.imgSong.setImageResource(it.image)
            binding.tvTitleSong.text = it.title
            binding.tvSingerSong.text = it.singer
        }

        binding.imgPlayOrPause.setOnClickListener {
            if (isPlaying) {
                sendActionToService(MyService.ACTION_PAUSE)
            } else {
                sendActionToService(MyService.ACTION_RESUME)
            }
        }

        binding.imgClear.setOnClickListener {
            sendActionToService(MyService.ACTION_CLEAR)
        }
    }

    private fun setStatusButtonPlayOrPause() {
        binding.imgPlayOrPause.setImageResource(if (isPlaying) R.drawable.pause_circle_48px else R.drawable.play_circle_48px)
    }

    private fun sendActionToService(action: Int) {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("action_music_service", action)

        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
    }
}