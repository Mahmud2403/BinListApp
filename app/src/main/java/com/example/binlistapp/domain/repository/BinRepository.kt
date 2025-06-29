package com.example.binlistapp.domain.repository

import com.example.binlistapp.data.local.model.BinHistoryEntity
import com.example.binlistapp.domain.model.BinInfo
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun getBinInfo(bin: String): Flow<BinInfo?>
}