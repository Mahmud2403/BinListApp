package com.example.binlistapp.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpace(height: Dp) = Spacer(modifier = Modifier.height(height))

@Composable
fun HorizontalSpacer(width: Dp) = Spacer(modifier = Modifier.width(width))


fun Modifier.clickableWithRipple(
    radius: Dp = 18.dp,
    color: Color = Color.Unspecified,
    enabled: Boolean = true,
    bounded: Boolean = false,
    onClick: () -> Unit,
): Modifier = composed {
    val interactionSource = remember { MutableInteractionSource() }

    this
        .indication(
            interactionSource = interactionSource,
            indication = ripple(
                radius = radius,
                bounded = bounded,
                color = color
            )
        )
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled,
            onClick = onClick
        )
}