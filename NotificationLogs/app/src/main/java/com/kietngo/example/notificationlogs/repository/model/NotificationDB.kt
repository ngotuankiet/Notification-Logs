package com.kietngo.example.notificationlogs.repository.model

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "TABLE_NOTIFICATION")
data class NotificationDB(
    @PrimaryKey() val id: Int,
    @ColumnInfo(name = "app_bundle") val appBundle : String,
    @ColumnInfo(name = "time") val time : String,
    @ColumnInfo(name ="title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "app_name") val appName: String
): Serializable