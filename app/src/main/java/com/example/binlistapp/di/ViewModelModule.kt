package com.example.binlistapp.di

import com.example.binlistapp.presentation.binlookup.vm.BinLookupViewModel
import com.example.binlistapp.presentation.history.vm.HistoryBinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BinLookupViewModel(get()) }
    viewModel { HistoryBinViewModel(get()) }
}