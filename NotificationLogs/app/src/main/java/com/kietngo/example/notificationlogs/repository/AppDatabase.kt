package com.kietngo.example.notificationlogs.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kietngo.example.notificationlogs.repository.model.NotificationDB

@Database(entities = [NotificationDB::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun notificationDao(): NotificationDao

    companion object{
        private const val NAME_DATABASE = "notification-logs"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    NAME_DATABASE
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(AppDatabaseCallBack(context))
                    .build()

                INSTANCE = instance

                instance
            }
        }

        private class AppDatabaseCallBack(
            val context: Context
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let{database ->
                    //TODO: khoi tao them value
                }
            }
        }


    }
}