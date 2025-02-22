package com.example.financera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TelaInicial(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo FinanceraAPP",
                    modifier = Modifier.size(50.dp).padding(5.dp)
                )
                Text(
                    "Financera.",
                    modifier = Modifier.wrapContentSize(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
        Text(
            "Esteja no controle da sua vida financeira",
            modifier = Modifier.wrapContentSize(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

        Button(
            onClick = { navController.navigate("tela_database") },
            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Black)
        ) {
            Text("Começar")
        }
    }
}