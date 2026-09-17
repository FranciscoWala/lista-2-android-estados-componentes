package com.example.estadoscomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estadoscomponentes.ui.theme.EstadosComponentesTheme
import com.example.estadoscomponentes.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadosComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(modifier = Modifier
                        .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen (modifier: Modifier = Modifier){
    Column(
        modifier= modifier
            .fillMaxSize()
            .background(Color(100, 236, 147, 255))
    ) {
        Text(
            text = "Aulas Android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3083DC),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
//                .background(Color.White)
                .fillMaxWidth(),
                textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "com JetPack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0, 0, 0, 255),
            fontFamily = Righteous,
                modifier= Modifier
                    .align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier

        ) {
            AndroidEnemy(
                modifier = Modifier.size(100.dp),
                color = Color.Red
            )
            AndroidEnemy(
                modifier = Modifier.size(100.dp),
                color = Color.Black
            )
        }

    }
}

@Composable
fun AndroidEnemy(
    modifier: Modifier = Modifier,
    color: Color
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}