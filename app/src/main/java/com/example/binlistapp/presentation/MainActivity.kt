package com.example.binlistapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.binlistapp.navigation.AppScreen
import com.example.binlistapp.navigation.rememberAppState
import com.example.binlistapp.presentation.theme.BinlistAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberAppState()
            BinlistAppTheme {
                AppScreen(
                    appState = appState,
                )
            }
        }
    }
}