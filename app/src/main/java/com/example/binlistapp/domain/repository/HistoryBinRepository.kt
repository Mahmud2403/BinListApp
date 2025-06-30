package com.example.binlistapp.domain.repository

import com.example.binlistapp.domain.model.HistoryBin
import kotlinx.coroutines.flow.Flow

interface HistoryBinRepository {
    suspend fun getAllHistoryBin(): Flow<List<HistoryBin>>
}