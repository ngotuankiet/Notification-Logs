package com.kietngo.example.notificationlogs

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kietngo.example.notificationlogs.model.NotificationLog
import com.kietngo.example.notificationlogs.repository.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
//                val livedataX = AppDatabase.getDatabase(application).notificationDao().getAllNotification()
//                val list = livedataX.value

            }
        }
    }
}
