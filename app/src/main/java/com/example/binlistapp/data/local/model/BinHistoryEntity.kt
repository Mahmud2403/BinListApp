package com.example.binlistapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "binHistory")
data class BinHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val bin: String?,
    val scheme: String?,
    val bankName: String?,
)
