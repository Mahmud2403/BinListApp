package com.example.binlistapp.presentation.binlookup.vm

import android.util.Log
import com.example.binlistapp.base.BaseViewModel
import com.example.binlistapp.base.collectAsResult
import com.example.binlistapp.domain.usecase.GetBinInfoUseCase
import com.example.binlistapp.presentation.binlookup.intents.BinLookupViewIntent
import com.example.binlistapp.presentation.binlookup.intents.BinLookupViewState

class BinLookupViewModel(
    private val useCase: GetBinInfoUseCase,
): BaseViewModel<BinLookupViewState,BinLookupViewIntent>(BinLookupViewState()) {

    override fun observe(event: BinLookupViewIntent) {
        when (event) {
            is BinLookupViewIntent.SendBinNumber -> {
                getBinInfo(bin = event.bin)
            }
            is BinLookupViewIntent.UpdateBinInput -> {
                updateState { copy(binText = event.input) }
            }
        }
    }

    private fun getBinInfo(bin: String) {
        launchIOCoroutine {
            useCase.invoke(bin).collectAsResult(
                onSuccess = { data ->
                    updateState {
                        copy(
                            isLoading = false,
                            binInfo = data
                        )
                    }
                },
                onLoading = {
                    updateState {
                        copy(
                            isLoading = true,
                            error = null,
                            binInfo = null,
                        )
                    }
                },
                onError = { error, _ ->
                    Log.e("qwerty", "getBinInfo: $error", )
                    updateState {
                        copy(
                            isLoading = false,
                            error = error,
                        )
                    }
                    Log.e("qwerty", "BinLookupCard: ${error}", )
                }
            )
        }
    }
}