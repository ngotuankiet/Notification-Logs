package com.kietngo.example.notificationlogs

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kietngo.example.notificationlogs.model.Device
import com.kietngo.example.notificationlogs.model.NotificationApp
import com.kietngo.example.notificationlogs.model.Posted
import okhttp3.*


class APIRequest {
    companion object{
        private const val PORT = "3007"
        private const val URL = "http://192.168.98.105:$PORT"
        private const val URL_DEVICE = "/device"
        private const val URL_POSTED = "/notification"
        private const val URL_APPS = "/apps"
        private const val POST ="POST"
        private const val GET = "GET"
        private val mediaType: MediaType? = MediaType.parse("application/json")

        fun getDevice(): Device{
            val client = OkHttpClient().newBuilder()
                .build()
            val request: Request = Request.Builder()
                .url(URL + URL_DEVICE)
                .method("GET", null)
                .build()
            val response: Response = client.newCall(request).execute()
            val json = response.body()?.string()
            val device : Device = Gson().fromJson(json, Device::class.java)
            Log.d("check", device.toString())

            return device
        }

        fun getAllNotification(): List<Posted>{
            val client = OkHttpClient().newBuilder()
                .build()
            val request: Request = Request.Builder()
                .url(URL + URL_POSTED)
                .method("GET", null)
                .build()

            val response: Response = client.newCall(request).execute()
            val json = response.body()?.string()
            //using TypeToken de tra ve
            val listPosted : List<Posted> = Gson().fromJson(json, object : TypeToken<List<Posted?>?>() {}.type)

            return listPosted
        }

        /**
         * @param posted gui 1 notification
         * @return true neu gui thanh cong
         * @return false neu gui false
         * */
        fun postNotification(posted: Posted?): Boolean{
            val client = OkHttpClient().newBuilder().build()
            val notificationToJson = Gson().toJson(posted)
            val body = RequestBody.create(mediaType, notificationToJson)
            val request = Request.Builder()
                    .url(URL+ URL_POSTED)
                    .method(POST, body)
                    .addHeader("Content-Type", "application/json")
                    .build()

            val response = client.newCall(request).execute()

            return response.isSuccessful
        }
        /**
         * @param  notificationApp 1 package thong tin
         * @return true neu gui thanh cong
         * @return false neu gui false
         * */
        fun postApps(notificationApp: NotificationApp): Boolean{
            val client = OkHttpClient().newBuilder().build()
            val appToJson = Gson().toJson(notificationApp)
            val body = RequestBody.create(mediaType,appToJson)
            val request = Request.Builder()
                    .url(URL + URL_APPS)
                    .method(POST, body)
                    .addHeader("Content-Type", "application/json")
                    .build()
            val response = client.newCall(request).execute()

            return response.isSuccessful
        }

        /**
         * @param device gui  thong tin thiet bi device
         * @return true neu gui thanh cong
         * @return false neu gui false
         * */
        fun postInfoDevice(device: Device): Boolean{
            val client = OkHttpClient().newBuilder().build()
            val json = Gson().toJson(device)

            val body = RequestBody.create(mediaType,json)
            val request = Request.Builder()
                    .url(URL + URL_DEVICE)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build()
            val response = client.newCall(request).execute()

            return response.isSuccessful
        }
    }
}