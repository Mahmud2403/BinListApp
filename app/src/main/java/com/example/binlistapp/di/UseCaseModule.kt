package com.example.binlistapp.di

import com.example.binlistapp.domain.usecase.GetAllHistoriesBinUseCase
import com.example.binlistapp.domain.usecase.GetBinInfoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetBinInfoUseCase(get()) }
    factory { GetAllHistoriesBinUseCase(get()) }
}