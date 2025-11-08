package com.example.tiendatenis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendatenis.ui.theme.TiendaTenisTheme
import com.example.tiendatenis.ui.theme.texts.Label

@Composable
fun RecuContra2Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        Label("Ingresa el código que enviamos al correo") 

        TextField(
            value = "",
            onValueChange = {},
            label = { Text(" * * * *") }
        )

        Label("Ingresa tu nueva contraseña") 

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") }
        )

        Label("Confirma tu contraseña")

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") }
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59)
            )
        ) {
            Label("Recuperar contraseña") 
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecuContra2Screen() {
    TiendaTenisTheme {
        RecuContra2Screen()
    }
}
