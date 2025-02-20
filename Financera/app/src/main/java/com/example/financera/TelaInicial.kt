package com.example.financera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financera.ui.theme.FinanceraTheme

class TelaInicial:ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //screen edge to edge
        setContent(){
            FinanceraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding -> TelaInicial(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TelaInicial(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            contentAlignment = Alignment.Center,
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo FinanceraAPP",
                    modifier = Modifier.size(50.dp)
                        .padding(5.dp)
                )
                Text("Financera.",
                    modifier = Modifier.wrapContentSize(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold)
            }
        }
        Text(
            "Esteja no controle da sua vida financeira",
            modifier = Modifier.wrapContentSize(),
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

        Button(onClick = {}, colors = ButtonColors(contentColor = Color.White, containerColor = Color.Black, disabledContentColor = Color.Gray, disabledContainerColor = Color.Black)) {
            Text("Começar")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinanceraTheme {
        TelaInicial()
    }
}