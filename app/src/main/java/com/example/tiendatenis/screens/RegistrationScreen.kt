package com.example.tiendatenis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
// IMPORTS NUEVOS:
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
// ---
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendatenis.R
import com.example.tiendatenis.ui.theme.TiendaTenisTheme
import com.example.tiendatenis.ui.theme.texts.Label

@Composable
fun RegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically)
    ) {

        // 1. Logo (Circular)
        Image(
            painter = painterResource(R.drawable.tennislogo),
            contentDescription = "Logo de nuestra app",
            modifier = Modifier
                .size(180.dp) // Tamaño del círculo
        )

        Spacer(modifier = Modifier.height(15.dp))

        // 2. Campo de Nombre
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("nombre") },
            placeholder = { Text("Ingresa tu usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Campo de Contraseña
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("contraseña") },
            placeholder = { Text("Ingresa tu contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        // 4. Campo de Verificación (Dividido en 4)
        Label("Ingresar numero de verificacion") // Título del campo
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Distribuye los 4 campos
        ) {
            val fieldModifier = Modifier
                .width(60.dp) // Ancho fijo para cada campo de dígito

            // Campo 1
            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), // <-- LÍNEA CORREGIDA
                singleLine = true
            )
            // Campo 2
            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), // <-- LÍNEA CORREGIDA
                singleLine = true
            )
            // Campo 3
            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), // <-- LÍNEA CORREGIDA
                singleLine = true
            )
            // Campo 4
            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), // <-- LÍNEA CORREGIDA
                singleLine = true
            )
        }

        // 5. Campo de Correo
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("correo") },
            placeholder = { Text("Ingresa tu correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 6. Botón "Continuar"
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59) // Tu color amarillo
            ),
            modifier = Modifier.fillMaxWidth(0.6f) // Ancho ajustado
        ) {
            Label("Continuar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    TiendaTenisTheme {
        RegistrationScreen()
    }
}