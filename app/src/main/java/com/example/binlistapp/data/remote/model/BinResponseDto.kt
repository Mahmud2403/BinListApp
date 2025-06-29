package com.example.binlistapp.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class BinResponseDto(
    val scheme: String?,
    val number: NumberDto?,
    val prepaid: Boolean?,
    val type: String?,
    val brand: String?,
    val country: CountryDto?,
    val bank: BankDto?
)

@Serializable
data class CountryDto(
    val numeric: String?,
    val name: String?,
    val alpha2: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Double?,
    val longitude: Double?
)

@Serializable
data class NumberDto(
    val length: String?,
    val luhn: Boolean?,
)

@Serializable
data class BankDto(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?
)

