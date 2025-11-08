package com.example.tiendatenis.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tiendatenis.database.DatabaseHelper
import com.example.tiendatenis.model.Product
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val dbHelper = remember { DatabaseHelper(context) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar Nuevo Producto") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre del producto") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && description.isNotBlank() && price.isNotBlank()) {
                        val newProduct = Product(
                            id = UUID.randomUUID().toString(),
                            name = name,
                            description = description,
                            price = price.toDoubleOrNull() ?: 0.0,
                            imageUrl = ""
                        )
                        dbHelper.insertProduct(newProduct)
                        showSuccess = true

                        // Limpiar campos
                        name = ""
                        description = ""
                        price = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Producto")
            }

            if (showSuccess) {
                Text(
                    "✓ Producto guardado exitosamente",
                    color = MaterialTheme.colorScheme.primary
                )
                LaunchedEffect(Unit) {
                    kotlinx.coroutines.delay(2000)
                    showSuccess = false
                    navController.popBackStack()
                }
            }
        }
    }
}
