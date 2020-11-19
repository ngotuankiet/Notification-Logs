package com.kietngo.example.notificationlogs

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kietngo.example.notificationlogs.model.Device
import com.kietngo.example.notificationlogs.model.NotificationApp
import com.kietngo.example.notificationlogs.model.NotificationLog
import com.kietngo.example.notificationlogs.model.Posted
import okhttp3.*


class APIRequest {
    companion object {
        private const val PORT = "3000"
        private const val URL = "http://192.168.1.10:$PORT"
        private const val URL_NOTIFICATION = "/notification"
        private const val POST = "POST"
        private const val GET = "GET"
        private val mediaType: MediaType? = MediaType.parse("application/json")

        /**
         * @return list notification
         * */
        fun getAllNotification(): List<NotificationLog> {
            val client = OkHttpClient().newBuilder()
                    .build()
            val request: Request = Request.Builder()
                    .url(URL + URL_NOTIFICATION)
                    .method("GET", null)
                    .build()

            val response: Response = client.newCall(request).execute()
            val json = response.body()?.string()
            //using TypeToken de tra ve
            return Gson().fromJson(json, object : TypeToken<List<NotificationLog?>?>() {}.type)
        }

        /**
         * @param notificationLog post notification
         * @return  True is post successfull
         * @return False is not post
         * */
        fun postNotification(notificationLog: NotificationLog): Boolean {
            val client = OkHttpClient().newBuilder()
                    .build()
            val notificationToJson = Gson().toJson(notificationLog)
            val body = RequestBody.create(mediaType, notificationToJson)
            val request: Request = Request.Builder()
                    .url(URL + URL_NOTIFICATION)
                    .method(POST, body)
                    .addHeader("Content-Type", "application/json")
                    .build()

            val response = client.newCall(request).execute()
            return response.isSuccessful
        }
    }
}