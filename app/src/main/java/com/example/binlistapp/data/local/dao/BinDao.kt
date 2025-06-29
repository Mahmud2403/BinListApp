package com.example.binlistapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binlistapp.data.local.model.BinHistoryEntity

@Dao
interface BinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBin(binHistoryEntity: BinHistoryEntity)

    @Query("SELECT * FROM binHistory")
    suspend fun getHistoryBin(): List<BinHistoryEntity>
}