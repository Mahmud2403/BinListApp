package com.example.binlistapp.presentation.history.vm

import com.example.binlistapp.base.BaseViewModel
import com.example.binlistapp.base.collectAsResult
import com.example.binlistapp.domain.usecase.GetAllHistoriesBinUseCase
import com.example.binlistapp.presentation.history.intents.HistoryBinViewEvent
import com.example.binlistapp.presentation.history.intents.HistoryBinViewState

class HistoryBinViewModel(
    private val getAllHistoriesBinUseCase: GetAllHistoriesBinUseCase
) : BaseViewModel<HistoryBinViewState, HistoryBinViewEvent>(
    HistoryBinViewState(isLoading = true)
) {

    init {
        getAllHistoryBin()
    }

    override fun observe(event: HistoryBinViewEvent) {

    }

    private fun getAllHistoryBin() {
        launchCoroutine {
            getAllHistoriesBinUseCase.invoke().collectAsResult(
                onLoading = {
                    updateState {
                        copy(
                            isLoading = true,
                            error = null,
                            historyBin = emptyList(),
                        )
                    }
                },
                onSuccess = {
                    updateState {
                        copy(
                            isLoading = false,
                            historyBin = it
                        )
                    }
                },
                onError = { er, _ ->
                    updateState {
                        copy(
                            isLoading = false,
                            error = er.message,
                        )
                    }
                }
            )
        }
    }
}