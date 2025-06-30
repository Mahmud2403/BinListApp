package com.example.binlistapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.binlistapp.common.CustomText
import com.example.binlistapp.domain.model.HistoryBin
import com.example.binlistapp.presentation.binlookup.components.InfoItem

@Composable
fun HistoryBinCard(
    modifier: Modifier = Modifier,
    data: HistoryBin,
    onClickBin: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp,
                    vertical = 8.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(36.dp),
        ) {
            InfoItem(
                title = "BIN",
                value = data.bin,
                enabled = true,
                onClick = onClickBin
            )
            Column {
                CustomText(
                    text = data.bankName,
                    color = Color.Gray,
                )
                CustomText(
                    text = data.scheme,
                    color = Color.Gray,
                )
            }

        }
    }
}