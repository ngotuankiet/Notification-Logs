package com.kietngo.example.notificationlogs.model

import com.google.gson.annotations.SerializedName

data class NotificationLog(
    @SerializedName("device")
    val device: Device,
    @SerializedName("posted")
    val listPosted: List<Posted>,
    @SerializedName("remove")
    val listRemove: List<String>
)