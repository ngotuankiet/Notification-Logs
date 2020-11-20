package com.kietngo.example.notificationlogs.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.kietngo.example.notificationlogs.APIRequest
import com.kietngo.example.notificationlogs.MainActivity
import com.kietngo.example.notificationlogs.model.NotificationLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class NotificationService: Service(){

    private val binder = Binder()

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationDB = intent?.getStringExtra("notification_test")
        //Gson().fromJson(json, object : TypeToken<List<NotificationLog?>?>() {}.type)
        val testNotifi = Gson().fromJson(notificationDB,NotificationLog::class.java)

        Log.d("check",testNotifi.toString())

        GlobalScope.launch(Dispatchers.IO){
            if (notificationDB !=null){

                val check = APIRequest.postNotification(testNotifi)
                Log.d("check", "on Service $check")
            }
        }

        createNotificationChanel()
        val pendingIntent : PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
            PendingIntent.getActivities(this, 0, arrayOf(notificationIntent), 0)
        }

        val notification : Notification =  Notification.Builder(this, "112")
            .setContentTitle("ds")
            .setContentText("ds")
            .setContentIntent(pendingIntent)
            .setTicker("ds")
            .build()

        startForeground(112, notification)

        return START_NOT_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
    }
    private fun createNotificationChanel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "test notifica"
            val descriptionText = "Show information Been Together"
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel("112", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}