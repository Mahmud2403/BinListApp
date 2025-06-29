package com.example.binlistapp.presentation.binlookup

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.binlistapp.R
import com.example.binlistapp.base.httpStatusCode
import com.example.binlistapp.common.BinLookupButton
import com.example.binlistapp.common.BinTextField
import com.example.binlistapp.common.CustomText
import com.example.binlistapp.common.ErrorMessage
import com.example.binlistapp.presentation.binlookup.components.BinLookupCard
import com.example.binlistapp.presentation.binlookup.components.BinLookupLoading
import com.example.binlistapp.presentation.binlookup.intents.BinLookupViewIntent
import com.example.binlistapp.presentation.binlookup.vm.BinLookupViewModel
import com.example.binlistapp.utils.VerticalSpace
import org.koin.androidx.compose.koinViewModel
import retrofit2.HttpException
import androidx.core.net.toUri
import com.example.binlistapp.presentation.binlookup.components.BinLookupEditField
import com.example.binlistapp.utils.clickableWithRipple

@Composable
fun BinLookupScreen(
    modifier: Modifier = Modifier,
    viewModel: BinLookupViewModel = koinViewModel(),
    onNavigateToHistory: () -> Unit,
) {

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    
    Scaffold(
        modifier = modifier
            .systemBarsPadding()
            .fillMaxSize(),
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
            ) {
                CustomText(
                    modifier = Modifier
                        .padding(
                            vertical = 4.dp,
                            horizontal = 8.dp
                        )
                        .clickableWithRipple(
                            onClick = onNavigateToHistory,
                        ),
                    text = "История",

                )
            }
        },
        containerColor = Color.DarkGray
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .padding(12.dp)
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BinLookupEditField(
                modifier = Modifier,
                binText = viewState.binText,
                isLoading = viewState.isLoading,
                onValueChange = {
                    viewModel.perform(BinLookupViewIntent.UpdateBinInput(it))
                },
                onClickLookup = {
                    viewModel.perform(BinLookupViewIntent.SendBinNumber(viewState.binText))
                },

            )
            VerticalSpace(8.dp)
            if (viewState.isLoading) {
                BinLookupLoading()
            }

            viewState.binInfo?.let { binInfo ->
                BinLookupCard(
                    binInfo = binInfo,
                    onUrlClick = { url ->
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        context.startActivity(intent)
                    },
                    onPhoneClick = { phone ->
                        val intent = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())
                        context.startActivity(intent)
                    },
                    onMapClick = { lat, lng ->
                        val gmmIntentUri = "geo:$lat,$lng?q=$lat,$lng".toUri()
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        context.startActivity(mapIntent)
                    }
                )
            }

            viewState.error?.let { throwable ->
                val httpErrorMessage = remember(throwable) {
                    (throwable as? HttpException)?.httpStatusCode?.userMessage?.let { id ->
                        "\n${context.getString(id)}"
                    }.orEmpty()
                }
                Log.e("qwerty", "BinLookupCard:$httpErrorMessage ", )
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ErrorMessage(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        message = httpErrorMessage,
                    )
                }
            }
        }
    }
}