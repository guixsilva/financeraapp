package com.example.financera.view

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.financera.viewmodel.NewDatabaseViewModel
import com.example.financera.viewmodel.ScanningViewModel
import java.io.File

@Composable
fun DatabaseCard(navController: NavController, databaseName: String, fileSize: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(databaseName)
            Text(fileSize)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatabasesScreen(navController: NavController, databaseFilesJson: String, modifier: Modifier = Modifier){
    val context = LocalContext.current
    val viewModel: ScanningViewModel = viewModel()
    val viewModel2: NewDatabaseViewModel= viewModel()

    val decodedJson = Uri.decode(databaseFilesJson)
    val databaseFilePaths = decodedJson.split(",")
    val databaseFiles = databaseFilePaths.map { File(it) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bancos disponíveis", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Encontramos bancos de dados já criados. Verifique se gostaria de usá-los ou criar um novo.",
                modifier = Modifier.padding(horizontal = 16.dp))
            

            databaseFiles.forEach{
                file -> val fileSize = viewModel.databaseFileSize(file.length())

                DatabaseCard(navController, file.name, fileSize)
            }

            Button(
                onClick = {
                    navController.navigate("tela_newdatabase")
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Black),
                modifier = Modifier.align(
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Text("Criar Banco novo")
            }
        }
    }
}