package com.example.binlistapp.navigation

sealed class Routes(val route: String) {
    data object BinLookup: Routes("bin_lookup")
    data object HistoryBin: Routes("history_bin")
}