package com.example.binlistapp.presentation.history.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.binlistapp.navigation.Direction
import com.example.binlistapp.navigation.Routes
import com.example.binlistapp.navigation.currentRout
import com.example.binlistapp.navigation.slideIntoContainer
import com.example.binlistapp.navigation.slideOutOfContainer
import com.example.binlistapp.navigation.targetRout
import com.example.binlistapp.presentation.history.HistoryBinScreen

fun NavGraphBuilder.history(
    onBackClick: () -> Unit
) {
    composable(
        route = Routes.HistoryBin.route,
        enterTransition = {
            when (currentRout()) {
                Routes.BinLookup.route -> slideIntoContainer(Direction.Left)
                else -> null
            }
        },
        exitTransition = {
            when (targetRout()) {
                Routes.BinLookup.route -> slideOutOfContainer(Direction.Right)
                else -> null
            }
        },
        popEnterTransition = {
            when (currentRout()) {
                Routes.BinLookup.route -> slideIntoContainer(Direction.Left)
                else -> null
            }
        },
        popExitTransition = {
            when (targetRout()) {
                Routes.BinLookup.route -> slideOutOfContainer(Direction.Right)
                else -> null
            }
        }
    ) {
        HistoryBinScreen(
            onBackClick = onBackClick
        )
    }
}
