package com.example.tiendatenis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tiendatenis.R
import com.example.tiendatenis.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.tennislogo),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = username,
            onValueChange = {
                username = it
                showError = false
            },
            label = { Text("Usuario") },
            placeholder = { Text("Ingresa tu usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
                showError = false
            },
            label = { Text("Contraseña") },
            placeholder = { Text("Ingresa tu contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (showError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Usuario o contraseña incorrectos", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (username == "admin" && password == "123") {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    showError = true
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E5E8A))
        ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text("Registrarse")
        }

        TextButton(onClick = { navController.navigate("forgot_password") }) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}
