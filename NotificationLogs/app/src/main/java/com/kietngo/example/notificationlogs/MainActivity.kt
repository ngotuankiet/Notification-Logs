package com.kietngo.example.notificationlogs

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.kietngo.example.notificationlogs.model.NotificationLog
import com.kietngo.example.notificationlogs.repository.AppDatabase
import com.kietngo.example.notificationlogs.service.NotificationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)


        button.setOnClickListener {
            startService()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun startService(){
        val testNotifi = NotificationLog("ds","ds","ds","ds")

        val serviceIntent : Intent = Intent(this, NotificationService::class.java)
        serviceIntent.putExtra("notification_test", Gson().toJson(testNotifi))

        startForegroundService(serviceIntent)
    }

    fun stopService(){
        val serviceIntent : Intent = Intent(this, NotificationService::class.java)
        stopService(serviceIntent)
    }

}
