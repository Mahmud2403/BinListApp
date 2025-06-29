package com.example.binlistapp.presentation.binlookup.intents

import com.example.binlistapp.base.BaseViewState
import com.example.binlistapp.domain.model.BinInfo

data class BinLookupViewState(
    val isLoading: Boolean = false,
    val binInfo: BinInfo? = null,
    val error: Throwable? = null,
    val binText: String = "",
): BaseViewState
