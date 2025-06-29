package com.example.binlistapp.presentation.binlookup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.binlistapp.common.BinLookupButton
import com.example.binlistapp.common.BinTextField
import com.example.binlistapp.presentation.binlookup.intents.BinLookupViewIntent

@Composable
fun BinLookupEditField(
    modifier: Modifier = Modifier,
    binText: String,
    isLoading: Boolean,
    onValueChange: (String) -> Unit,
    onClickLookup: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        BinTextField(
            modifier = Modifier
                .weight(1f),
            value = binText,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = "Введите BIN карты",
                    color = Color.Gray
                )
            },
            innerPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp)
        )
        BinLookupButton(
            modifier = Modifier
                .padding(start = 12.dp),
            onClick = onClickLookup,
            enable = !isLoading,
            backgroundColor = Color.White,
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 6.dp,
                        vertical = 12.dp
                    ),
                text = "Lookup",
                color = Color.Black,
            )
        }
    }
}