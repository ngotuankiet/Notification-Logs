package com.kietngo.example.notificationlogs

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceNotification {

    companion object{
        const val URL = "http://192.168.98.105:3000/device"
        private var retrofit: Retrofit? = null
        private val gson : Gson = GsonBuilder().create()
        fun <T> createService(serviceClass: Class<T>?): T? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit?.create(serviceClass)
        }

    }
}