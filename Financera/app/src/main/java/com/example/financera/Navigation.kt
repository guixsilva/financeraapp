package com.example.financera

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(startDestination: String = "tela_inicial") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("tela_inicial") { TelaInicial(navController) }
    }
}