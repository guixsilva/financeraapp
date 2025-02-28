package com.example.financera

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewDatabase(navController: NavController, modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    val databasename by remember { derivedStateOf { "$username"+"_database" } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Novo Banco", fontSize = 20.sp) },
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
            OutlinedTextField(
                value = username,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 10.dp),
                onValueChange = {username = it},
                shape = RoundedCornerShape(20.dp),
                placeholder = {Text("Insira seu nome")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )
            if(username != ""){
                Text("Nome do arquivo: $databasename",
                    modifier = Modifier.wrapContentSize().padding(horizontal = 20.dp, vertical = 10.dp),
                    textAlign = TextAlign.Start)
            }else{
                Text("Nome do arquivo: ",
                    modifier = Modifier.wrapContentSize().padding(horizontal = 20.dp, vertical = 10.dp),
                    textAlign = TextAlign.Start)
            }

            Button(
                onClick = { navController.navigate("") },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Black),
                modifier = Modifier.align(
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Text("Criar Banco")
            }

        }

    }
}