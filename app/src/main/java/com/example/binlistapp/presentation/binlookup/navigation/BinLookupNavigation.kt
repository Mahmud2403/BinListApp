package com.example.binlistapp.presentation.binlookup.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.binlistapp.navigation.Direction
import com.example.binlistapp.navigation.Routes
import com.example.binlistapp.navigation.currentRout
import com.example.binlistapp.navigation.slideIntoContainer
import com.example.binlistapp.navigation.slideOutOfContainer
import com.example.binlistapp.navigation.targetRout
import com.example.binlistapp.presentation.binlookup.BinLookupScreen


fun NavGraphBuilder.lookup(
    navigateTo: (route: String) -> Unit
) {
    composable(
        route = Routes.BinLookup.route,
        enterTransition = {
            when (currentRout()) {
                Routes.HistoryBin.route -> slideIntoContainer(Direction.Right)
                else -> null
            }
        },
        exitTransition = {
            when (targetRout()) {
                Routes.HistoryBin.route -> slideOutOfContainer(Direction.Left)
                else -> null
            }
        },
        popEnterTransition = {
            when (currentRout()) {
                Routes.HistoryBin.route -> slideIntoContainer(Direction.Right)
                else -> null
            }
        },
        popExitTransition = {
            when (targetRout()) {
                Routes.HistoryBin.route -> slideOutOfContainer(Direction.Left)
                else -> null
            }
        }
    ) {
        BinLookupScreen(
            onNavigateToHistory = {
                navigateTo(Routes.HistoryBin.route)
            }
        )
    }
}