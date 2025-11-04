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

        Image(
            painter = painterResource(R.drawable.tennislogo),
            contentDescription = "Logo de nuestra app",
            modifier = Modifier
                .size(180.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

      
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("nombre") },
            placeholder = { Text("Ingresa tu usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("contraseña") },
            placeholder = { Text("Ingresa tu contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Label("Ingresar numero de verificacion") 
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly 
        ) {
            val fieldModifier = Modifier
                .width(60.dp)

            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), A
                singleLine = true
            )
            TextField(
                value = "",
                onValueChange = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Center), 
                singleLine = true
            )
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
                textStyle = TextStyle(textAlign = TextAlign.Center),
                singleLine = true
            )
        }

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("correo") },
            placeholder = { Text("Ingresa tu correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFDE59) 
            ),
            modifier = Modifier.fillMaxWidth(0.6f) 
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
