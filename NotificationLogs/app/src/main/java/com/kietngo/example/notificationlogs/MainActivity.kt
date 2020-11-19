package com.kietngo.example.notificationlogs

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kietngo.example.notificationlogs.model.NotificationLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)

        val notificationLog = NotificationLog("das","ds","d","d")
        button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                APIRequest.postNotification(notificationLog)
            }
        }
    }
}
