package com.kietngo.example.notificationlogs

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.kietngo.example.notificationlogs.model.Device
import com.kietngo.example.notificationlogs.model.NotificationApp
import com.kietngo.example.notificationlogs.model.NotificationLog
import com.kietngo.example.notificationlogs.model.Posted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)
        //val device = Device("15","2","4","d","d","d",12,"d","d","d")
        //val nameApp = NotificationApp("das","das","ds","ds")
//        val post = Posted("d",",","d",1,1,1,"d",
//                "d","d",1,1,1,1,1,1,1,"1","1",1,"d","d"
//                ,"d","d","d","d",1,"d",1,"d","d" +
//                "","d","d","d","d","d","d","d",1,"d","d","d","d","d","d","d")
        button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
//                val check = APIRequest.postNotification(post)
//                Log.d("check", check.toString())
            }
        }
    }
}

/*
* ~/AndroidStudioProjects/Notification Logs/Server$ json-server --host 192.168.98.105 --port 3006 Notification_Logs.json
* */