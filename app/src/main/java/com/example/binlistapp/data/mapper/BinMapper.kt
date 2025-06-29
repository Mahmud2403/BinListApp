package com.example.binlistapp.data.mapper

import com.example.binlistapp.data.local.model.BinHistoryEntity
import com.example.binlistapp.data.remote.model.BinResponseDto
import com.example.binlistapp.domain.model.BinInfo
import com.example.binlistapp.domain.model.HistoryBin

fun BinResponseDto.toDomain(bin: String): BinInfo = BinInfo(
    scheme = scheme,
    type = type,
    brand = brand,
    countryName = country?.name,
    countryEmoji = country?.emoji,
    latitude = country?.latitude,
    longitude = country?.longitude,
    bankName = bank?.name,
    bankUrl = bank?.url,
    bankPhone = bank?.phone,
    bankCity = bank?.city,
    bin = bin,
    numberLength = number?.length,
    numberLuhn = number?.luhn
)

fun BinResponseDto.toEntity(bin: String): BinHistoryEntity = BinHistoryEntity(
    bin = bin,
    scheme = scheme,
    bankName = bank?.name,
)

fun BinHistoryEntity.toDomain(): HistoryBin = HistoryBin(
    bin = bin.orEmpty(),
    scheme = scheme.orEmpty(),
    bankName = bankName.orEmpty(),
)
