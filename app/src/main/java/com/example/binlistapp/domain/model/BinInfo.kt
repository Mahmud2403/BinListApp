package com.example.binlistapp.domain.model

data class BinInfo(
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val countryName: String?,
    val countryEmoji: String?,
    val latitude: Double?,
    val longitude: Double?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
    val bin: String,
    val numberLength: String?,
    val numberLuhn: Boolean?
)
