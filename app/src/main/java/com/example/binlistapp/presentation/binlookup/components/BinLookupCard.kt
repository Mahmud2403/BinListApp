package com.example.binlistapp.presentation.binlookup.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.binlistapp.common.CustomText
import com.example.binlistapp.domain.model.BinInfo
import com.example.binlistapp.utils.HorizontalSpacer
import com.example.binlistapp.utils.VerticalSpace
import com.example.binlistapp.utils.clickableWithRipple

@Composable
fun BinLookupCard(
    modifier: Modifier = Modifier,
    binInfo: BinInfo?,
    onUrlClick: (String) -> Unit,
    onPhoneClick: (String) -> Unit,
    onMapClick: (Double, Double) -> Unit,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            binInfo?.let { info ->
                Row(Modifier.fillMaxWidth()) {
                    Column(Modifier.weight(1f)) {
                        InfoItem(
                            title = "SCHEME / NETWORK",
                            value = info.scheme,
                            enabled = false
                        )
                        InfoItem(
                            title = "TYPE",
                            value = info.type,
                            enabled = false,
                        )
                        InfoItem(
                            title = "BRAND",
                            value = info.brand,
                            enabled = false,
                        )
                        InfoItem(
                            title = "CARD NUMBER",
                            value = "Length: ${info.numberLength ?: "-"}\nLuhn: ${if (info.numberLuhn == true) "Yes" else "No"}",
                            enabled = false,
                        )
                        InfoItem(
                            title = "COUNTRY",
                            value = "${info.countryEmoji} ${info.countryName}",
                            enabled = false,
                        )
                        InfoItem(
                            title = "LOCATION",
                            value = "lat: ${info.latitude} \nlong: ${info.longitude}",
                            enabled = true,
                        )  {
                            info.let {
                                Log.e("qwerty", "BinLookupCard: ", )
                                onMapClick(it.latitude ?: 0.0, it.longitude ?: 0.0)
                            }
                        }
                        VerticalSpace(45.dp)
                    }
                    HorizontalSpacer(16.dp)

                    Column(Modifier.weight(1f)) {
                        InfoItem(
                            title = "BANK",
                            value = info.bankName,
                            enabled = false,
                        )
                        ClickableTextItem(
                            title = "URL",
                            value = info.bankUrl
                        ) {
                            onUrlClick(it)
                        }
                        ClickableTextItem(
                            title = "Phone",
                            value = info.bankPhone
                        ) {
                            onPhoneClick(it)
                        }

                        InfoItem(
                            title = "City",
                            value = info.bankCity,
                            enabled = false,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String?,
    enabled: Boolean,
    onClick:(() -> Unit) = {},
) {
    Column(
        modifier = modifier
            .clickableWithRipple(
                enabled = enabled,

                ) {
                Log.e("qwerty", "InfoItem: ",)
                onClick.invoke()
            }
            .padding(vertical = 4.dp)
    ) {
        CustomText(
            text = title,
            fontSize = 12.sp,
            color = Color.Gray,
            maxLines = Int.MAX_VALUE,
        )
        CustomText(
            text = value ?: "-",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = Int.MAX_VALUE,
        )
    }
}

@Composable
fun ClickableTextItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String?,
    onClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(vertical = 4.dp)
            .clickableWithRipple(
                enabled = !value.isNullOrEmpty()
            ) {
                value?.let {
                    onClick(it)
                }
            }
    ) {
        CustomText(
            text = title,
            fontSize = 12.sp,
            color = Color.Gray,
        )
        CustomText(
            text = value ?: "-",
            color = if(!value.isNullOrEmpty()) Color.Blue else Color.White,
            textDecoration = if(!value.isNullOrEmpty()) TextDecoration.Underline else TextDecoration.None,
        )
    }
}