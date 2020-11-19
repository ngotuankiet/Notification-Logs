package com.kietngo.example.notificationlogs.model

import com.google.gson.annotations.SerializedName

data class NotificationApp(
    @SerializedName("appName") val appName: String?,
    @SerializedName("packageName") val packageName: String?,
    @SerializedName("enabled") val enable : String?,
    @SerializedName("system") val system : String?
)