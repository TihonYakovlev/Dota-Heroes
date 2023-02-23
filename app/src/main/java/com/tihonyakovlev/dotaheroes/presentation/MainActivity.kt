package com.tihonyakovlev.dotaheroes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.ramcosta.composedestinations.DestinationsNavHost
import com.tihonyakovlev.dotaheroes.ui.theme.DotaHeroesTheme
import androidx.compose.runtime.getValue
import com.tihonyakovlev.dotaheroes.presentation.screens.NavGraphs

var darkMode by mutableStateOf(false)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DotaHeroesTheme(darkMode) {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}