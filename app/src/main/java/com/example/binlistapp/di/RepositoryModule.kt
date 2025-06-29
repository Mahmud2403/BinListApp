package com.example.binlistapp.di

import com.example.binlistapp.data.repository.BinRepositoryImpl
import com.example.binlistapp.data.repository.HistoryBinRepositoryImpl
import com.example.binlistapp.domain.repository.BinRepository
import com.example.binlistapp.domain.repository.HistoryBinRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<BinRepository> { BinRepositoryImpl(get(), get()) }
    single<HistoryBinRepository> { HistoryBinRepositoryImpl(get()) }
}