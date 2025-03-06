package com.example.financera

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.financera.view.DatabasesScreen
import com.example.financera.view.NewDatabase
import com.example.financera.view.ScanningScreen

@Composable
fun NavGraph(startDestination: String = "tela_inicial", modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable("tela_inicial") {
            TelaInicial(navController, modifier = Modifier.padding(16.dp))
        }

        composable("tela_newdatabase") {
            NewDatabase(navController, modifier = Modifier.padding(16.dp))
        }

        composable("tela_scanning") {
            ScanningScreen(navController, modifier = Modifier.padding(16.dp))
        }

        composable("tela_databases/{databaseFilesJson}", arguments = listOf(navArgument("databaseFilesJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val databaseFilesJson = backStackEntry.arguments?.getString("databaseFilesJson") ?: ""
            DatabasesScreen(navController, databaseFilesJson = databaseFilesJson, modifier = Modifier.padding(16.dp))
        }
    }
}