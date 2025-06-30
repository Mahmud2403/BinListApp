package com.example.binlistapp.data.repository

import com.example.binlistapp.data.local.dao.BinDao
import com.example.binlistapp.data.mapper.toDomain
import com.example.binlistapp.domain.model.HistoryBin
import com.example.binlistapp.domain.repository.HistoryBinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryBinRepositoryImpl(
    private val dao: BinDao
) : HistoryBinRepository {

    override suspend fun getAllHistoryBin(): Flow<List<HistoryBin>> = flow {
        val history = dao.getHistoryBin()
            .map { list -> list.toDomain() }
        emit(history)
    }
}