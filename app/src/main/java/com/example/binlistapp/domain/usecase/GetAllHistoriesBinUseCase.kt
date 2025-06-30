package com.example.binlistapp.domain.usecase

import com.example.binlistapp.domain.model.HistoryBin
import com.example.binlistapp.domain.repository.HistoryBinRepository
import kotlinx.coroutines.flow.Flow

class GetAllHistoriesBinUseCase(
    private val repository: HistoryBinRepository
) {
    suspend operator fun invoke(): Flow<List<HistoryBin>> {
        return repository.getAllHistoryBin()
    }
}