package com.example.binlistapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.binlistapp.presentation.binlookup.navigation.lookup
import com.example.binlistapp.presentation.history.navigation.history

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onNavigation: (route: String) -> Unit,
    onClickBack: () -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Routes.BinLookup.route,
    ) {
        lookup(
            navigateTo = onNavigation
        )
        history(
            onBackClick = onClickBack
        )
    }
}



const val DURATION_NAVIGATION_ANIMATION = 600

fun AnimatedContentTransitionScope<NavBackStackEntry>.currentRout() = initialState.destination.route

fun AnimatedContentTransitionScope<NavBackStackEntry>.targetRout() = targetState.destination.route

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideIntoContainer(direction: Direction): EnterTransition {
    val slideDirection = when (direction) {
        Direction.Right -> AnimatedContentTransitionScope.SlideDirection.Right
        Direction.Left -> AnimatedContentTransitionScope.SlideDirection.Left
        Direction.Up -> AnimatedContentTransitionScope.SlideDirection.Up
        Direction.Down -> AnimatedContentTransitionScope.SlideDirection.Down
    }
    return slideIntoContainer(
        slideDirection,
        animationSpec = tween(
            durationMillis = DURATION_NAVIGATION_ANIMATION,
            easing = EaseInOutQuad
        )
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutOfContainer(direction: Direction): ExitTransition {
    val slideDirection = when (direction) {
        Direction.Right -> AnimatedContentTransitionScope.SlideDirection.Right
        Direction.Left -> AnimatedContentTransitionScope.SlideDirection.Left
        Direction.Up -> AnimatedContentTransitionScope.SlideDirection.Up
        Direction.Down -> AnimatedContentTransitionScope.SlideDirection.Down
    }
    return slideOutOfContainer(
        slideDirection,
        animationSpec = tween(
            durationMillis = DURATION_NAVIGATION_ANIMATION,
            easing = EaseInOutQuad
        )
    )
}

enum class Direction {
    Right, Left, Up, Down
}
