package com.example.tiendatenis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar Nuevo Producto") },
                navigationIcon = {
                    // Flecha para volver atrás
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->

        // Un formulario simple
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Campo para el Nombre
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Nombre del producto") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo para la Descripción
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            // Campo para el Precio
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de Guardar (sin funcionalidad, como pide Req 12)
            Button(
                onClick = { /* No hace nada */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Producto")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddProductScreen() {
    TiendaTenisTheme {
        AddProductScreen(navController = rememberNavController())
    }
}
