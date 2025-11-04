package com.example.tiendatenis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendatenis.R
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

import com.example.tiendatenis.ui.theme.texts.Label

@Composable
fun RecuContraScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Image(
            painter = painterResource(R.drawable.tennislogo),
            contentDescription = "Logo de nuestra app"
        )

        Label("Ingresa tu correo electronico") // Ahora debería encontrarlo

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Correo electrónico") }
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59)
            )
        ) {
            Label("Continuar") // Ahora debería encontrarlo
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecuContraScreen() {
    TiendaTenisTheme {
        RecuContraScreen()
    }
}