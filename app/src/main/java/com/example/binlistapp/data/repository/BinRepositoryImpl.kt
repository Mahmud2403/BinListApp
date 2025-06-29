package com.example.binlistapp.data.repository

import com.example.binlistapp.data.local.dao.BinDao
import com.example.binlistapp.data.local.model.BinHistoryEntity
import com.example.binlistapp.data.mapper.toDomain
import com.example.binlistapp.data.mapper.toEntity
import com.example.binlistapp.data.remote.BinApi
import com.example.binlistapp.domain.model.BinInfo
import com.example.binlistapp.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException

class BinRepositoryImpl(
    private val api: BinApi,
    private val dao: BinDao
) : BinRepository {

    override suspend fun getBinInfo(bin: String): Flow<BinInfo?> = flow {
        val response = api.getBinInfo(bin)
        val binInfo = response.body()?.toDomain(bin)

        if (!response.isSuccessful) {
            throw HttpException(response)
        }

        emit(binInfo)

        response.body()?.let {
            dao.insertBin(it.toEntity(bin))
        }
    }
}
