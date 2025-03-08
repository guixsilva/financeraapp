package com.example.financera.view

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.financera.R
import com.example.financera.viewmodel.ScanningViewModel
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

@Composable
fun ScanningScreen(navController: NavController, modifier: Modifier = Modifier) {
    val viewModel: ScanningViewModel = viewModel()
    val context = LocalContext.current
    val databaseFiles by viewModel.databaseFiles.collectAsState() // coleta lista de databases

    LaunchedEffect(Unit) {
        viewModel.scanDatabases(context)
    }

    LaunchedEffect(databaseFiles) {
        delay(5000)
        //cria string json quando há databases criados
        if (databaseFiles.isNotEmpty() || viewModel.databaseFiles.value.isNotEmpty()) {
            val databaseFilesJson = databaseFiles.map { it.absolutePath }.joinToString(",")
            val encodedJson = Uri.encode(databaseFilesJson)
            navController.navigate("tela_databases/$encodedJson")
        }else{
            navController.navigate("tela_newdatabase")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo FinanceraAPP",
                    modifier = Modifier.size(50.dp).padding(5.dp)
                )
                Text(
                    "Analisando se há bancos disponíveis...",
                    modifier = Modifier.wrapContentSize(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}