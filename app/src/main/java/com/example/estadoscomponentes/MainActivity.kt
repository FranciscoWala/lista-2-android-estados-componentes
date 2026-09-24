package com.example.estadoscomponentes

import android.os.Bundle
import android.sax.RootElement
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
                    BasicComponentsScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {

    //Para utilizar o by, em variável, usa-se o atalho option + shift + enter -> no mac
    //VARIÁVEIS DE ESTADO
    var textoInput by remember {
        mutableStateOf("")
    }

    var quantidade by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jcompose by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf("")
    }

    var corFundo by remember {
        mutableStateOf(Color(100, 236, 147, 255))
    }

    var favoritado by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)
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
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Column (
            modifier = Modifier
        ) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textoInput,
                onValueChange = { novoValor ->
                    Log.i("teste", novoValor)
                    textoInput = novoValor
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words
                ),
                label = {
                    Text("Primeiro valor")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66,133,244)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66,133,244)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = quantidade,
                onValueChange = { novoValor ->
                    Log.i("teste", novoValor)
                    quantidade = novoValor
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                placeholder = {
                    Text(
                        text = "Segundo valor "
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Black,
                    unfocusedPlaceholderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Resultado"
                    )
                },
                placeholder = {
                    Text(
                        text = "Ex: 50 "
                    )
                },
                shape = RoundedCornerShape(
                    topEnd = 10.dp,
                    bottomEnd = 10.dp,
                    topStart = 10.dp,
                    bottomStart = 10.dp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Black
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = kotlin,
                    onCheckedChange = {kotlin = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Blue
                    )
                )
                Text(
                    text = "Kotlin"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = jcompose,
                    onCheckedChange = {jcompose = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Blue
                    )
                )
                Text(
                    text = "JCompose"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = android,
                    onCheckedChange = {android = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Blue
                    )
                )
                Text(
                    text = "Android"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == "wi",
                    onClick = {sistemaSelecionado = "wi"}
                )
                Text(text = "Windows")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == "li",
                    onClick = {sistemaSelecionado = "li"}
                )
                Text(text = "Linux")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = sistemaSelecionado == "mo",
                    onClick = {sistemaSelecionado = "mo"}
                )
                Text(text = "MacOs")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        corFundo = Color(66,133,244)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(
                        topEnd = 50.dp,
                        bottomStart = 50.dp,
                        topStart = 50.dp,
                        bottomEnd = 50.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = "Done"
                        )
                        Text(
                            text = "Submit!"
                        )
                    }
                }

                OutlinedButton(onClick = {
                    corFundo = Color(100, 236, 147, 255)
                }) {
                    Text(
                        text = "Outro botão"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                if (favoritado) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{favoritado = false},
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite button icon full"
                    )
                }else {
                    Icon(
                        modifier = Modifier.size(20.dp)
                            .clickable{favoritado = true},
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite button icon void"
                    )
                }
            }
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