package com.kietngo.example.notificationlogs.model

import com.google.gson.annotations.SerializedName

data class Device(
    @SerializedName("version") val version: String?,
    @SerializedName("locale") val locale: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("device") val device: String?,
    @SerializedName("product") val product: String?,
    @SerializedName("manufacturer") val manufacturer: String?,
    @SerializedName("sdk") val sdk: Int?,
    @SerializedName("timezone") val timeZone: String?,
    @SerializedName("offset") val offset: String?,
    @SerializedName("exportTime") val exportTime: String?
)