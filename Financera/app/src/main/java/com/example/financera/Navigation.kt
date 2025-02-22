package com.example.financera

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp

@Composable
fun NavGraph(startDestination: String = "tela_inicial", modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable("tela_inicial") {
            TelaInicial(navController, modifier = Modifier.padding(16.dp))
        }
        composable("tela_database") {
            NewDatabase(navController, modifier = Modifier.padding(16.dp));
        }
    }
}