package com.example.binlistapp.domain.usecase

import com.example.binlistapp.domain.model.BinInfo
import com.example.binlistapp.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow

class GetBinInfoUseCase(
    private val repository: BinRepository
) {
    suspend operator fun invoke(bin: String): Flow<BinInfo?> {
        return repository.getBinInfo(bin)
    }
}