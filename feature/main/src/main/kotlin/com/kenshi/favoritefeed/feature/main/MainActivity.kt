package com.kenshi.favoritefeed.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.kenshi.favoritefeed.core.designsystem.theme.FavoriteFeedTheme
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val navigator: MainNavController = rememberMainNavController()
            val systemUiController = rememberExSystemUiController()

            DisposableEffect(systemUiController) {
                systemUiController.setSystemBarsColor(
                    color = Color.White,
                    darkIcons = true,
                    isNavigationBarContrastEnforced = false,
                )

                onDispose {}
            }

            FavoriteFeedTheme {
                MainScreen(
                    navigator = navigator,
                )
            }
        }
    }
}
