package com.example.binlistapp.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binlistapp.data.local.model.BinHistoryEntity

@Database(
    entities = [
        BinHistoryEntity::class
    ],
    version = 1
)
abstract class BinDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}