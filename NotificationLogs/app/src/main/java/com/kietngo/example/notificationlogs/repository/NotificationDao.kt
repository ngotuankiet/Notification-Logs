package com.kietngo.example.notificationlogs.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kietngo.example.notificationlogs.repository.model.NotificationDB

@Dao
interface NotificationDao {
    @Query("SELECT * FROM TABLE_NOTIFICATION")
    fun getAllNotification(): LiveData<List<NotificationDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNotification(notificationDB: NotificationDB)

    @Query("SELECT * FROM table_notification WHERE id = :id")
    fun loadNotificationWithId(id: Int) : LiveData<NotificationDB>

    @Update
    suspend fun updateNotification(vararg notificationDB: NotificationDB)
}