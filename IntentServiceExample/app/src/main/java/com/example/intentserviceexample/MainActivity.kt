package com.example.intentserviceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.ResultReceiver
import android.widget.ProgressBar
import android.widget.Toast
import com.example.intentserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.downloadButton.setOnClickListener {
            startDownload()
        }
    }

    private fun startDownload() {
        val intent = Intent(this, DownloadService::class.java)
        intent.putExtra("url", "https://example.com/samplefile.txt")

        // Sử dụng ResultReceiver để nhận kết quả từ IntentService
        val receiver = DownloadReceiver(Handler())
        intent.putExtra("receiver", receiver)

        startService(intent)
    }

    // Receiver để nhận thông báo khi tải xuống hoàn tất
    private inner class DownloadReceiver(handler: Handler) : ResultReceiver(handler) {
        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            super.onReceiveResult(resultCode, resultData)

            if (resultCode == 0) {
                val progress = resultData?.getInt("progress")
                progress?.let {
                    progressBar.progress = it
                    if (it == 100) {
                        Toast.makeText(this@MainActivity, "Download completed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}