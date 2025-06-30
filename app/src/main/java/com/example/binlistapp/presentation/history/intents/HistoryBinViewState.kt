package com.example.binlistapp.presentation.history.intents

import com.example.binlistapp.base.BaseViewState
import com.example.binlistapp.domain.model.HistoryBin

data class HistoryBinViewState(
    val isLoading: Boolean = false,
    val historyBin: List<HistoryBin> = emptyList(),
    val error: String? = null,
): BaseViewState
