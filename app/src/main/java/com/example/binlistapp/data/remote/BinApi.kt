package com.example.binlistapp.data.remote

import com.example.binlistapp.data.remote.model.BinResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): Response<BinResponseDto>
}

