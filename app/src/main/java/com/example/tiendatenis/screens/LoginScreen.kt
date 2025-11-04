package com.example.tiendatenis.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tiendatenis.R
import com.example.tiendatenis.ui.theme.TiendaTenisTheme
import com.example.tiendatenis.ui.theme.texts.Label
import com.example.tiendatenis.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {

    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            navController.navigate("home") {
                // Limpiamos el historial para que no pueda volver al login con el botón de atrás
                popUpTo("login") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically)
    ) {
        Image(painter = painterResource(R.drawable.tennislogo), "Logo", Modifier.size(180.dp))
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = username,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = { Text("usuario") },
            leadingIcon = { Icon(Icons.Default.Person, null) },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, null) },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(value = "", onValueChange = {}, label = { Text("correo") }, leadingIcon = { Icon(Icons.Default.Email, null) }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                // La lógica ahora está en el ViewModel, solo le avisamos del intento
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    viewModel.login()
                } else {
                    Toast.makeText(context, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFDE59)),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Label("Continuar")
        }
        Button(
            onClick = { navController.navigate("register") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Label("Registrarse")
        }
        Text(
            text = "¿Olvidaste tu contraseña?",
            color = Color.Gray,
            modifier = Modifier.clickable { navController.navigate("forgot_password") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    TiendaTenisTheme {
        LoginScreen(navController = rememberNavController(), viewModel = viewModel())
    }
}