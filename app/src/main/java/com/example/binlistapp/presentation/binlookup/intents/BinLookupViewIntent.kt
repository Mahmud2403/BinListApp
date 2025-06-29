package com.example.binlistapp.presentation.binlookup.intents

import com.example.binlistapp.base.BaseViewEvent

sealed class BinLookupViewIntent: BaseViewEvent {
    data class SendBinNumber(val bin: String): BinLookupViewIntent()
    data class UpdateBinInput(val input: String) : BinLookupViewIntent()
}