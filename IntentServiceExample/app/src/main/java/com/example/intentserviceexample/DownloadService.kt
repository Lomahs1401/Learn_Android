package com.example.intentserviceexample

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

class DownloadService : IntentService("DownloadService") {

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        val url = intent?.getStringExtra("url")
        val receiver = intent?.getParcelableExtra<ResultReceiver>("receiver")

        try {
            url?.let {
                val downloadUrl = URL(it)
                val connection: URLConnection = downloadUrl.openConnection()
                connection.connect()

                val fileLength = connection.contentLength

                val input: InputStream = BufferedInputStream(downloadUrl.openStream())
                val output: FileOutputStream = openFileOutput("downloaded_file", MODE_PRIVATE)

                val data = ByteArray(1024)
                var total = 0
                var count: Int
                while (input.read(data).also { count = it } != -1) {
                    total += count
                    output.write(data, 0, count)

                    // Tính toán tiến trình và gửi thông báo đến Receiver
                    val progress = (total * 100 / fileLength)
                    val resultData = Bundle().apply {
                        putInt("progress", progress)
                    }
                    receiver?.send(0, resultData)
                }

                output.flush()
                output.close()
                input.close()

                Log.d(TAG, "Download completed")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val TAG = "DownloadService"
    }
}