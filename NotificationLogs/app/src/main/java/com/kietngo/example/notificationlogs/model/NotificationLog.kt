package com.kietngo.example.notificationlogs.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NotificationLog(
    @SerializedName("app_bundle")
    val appBundle: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
): Serializable