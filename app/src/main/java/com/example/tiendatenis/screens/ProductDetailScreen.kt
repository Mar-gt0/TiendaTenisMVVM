package com.example.tiendatenis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tiendatenis.R
import com.example.tiendatenis.model.Product
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, product: Product?) {

    var selectedSize by remember { mutableStateOf("25") }
    var selectedColor by remember { mutableStateOf("Verdes") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comprar") }, 
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->

        if (product == null) {
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) {
                Text("Producto no encontrado")
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "$${product.price}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.tennislogo),
                contentDescription = product.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Tenis star ${selectedColor.lowercase()}", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(24.dp))

            // Selector de Tallas
            Text("Tallas disponibles", modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("22", "23", "24", "25", "26").forEach { size ->
                    SizeButton(
                        text = size,
                        isSelected = selectedSize == size,
                        onClick = { selectedSize = size }
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text("Colores disponibles", modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Verdes", "Rosa", "Rojo").forEach { color ->
                    ColorButton(
                        text = color,
                        isSelected = selectedColor == color,
                        onClick = { selectedColor = color }
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f)) 

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { navController.popBackStack() }, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)) {
                    Text("Cancelar")
                }

                Button(onClick = { navController.popBackStack() }) { 
                    Text("Guardar cambios")
                }

                }
            }
        }
    }


@Composable
fun SizeButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray
    val contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Black

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, contentColor = contentColor),
        shape = MaterialTheme.shapes.small
    ) {
        Text(text)
    }
}

@Composable
fun ColorButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray
    val contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Black

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, contentColor = contentColor),
        shape = MaterialTheme.shapes.small
    ) {
        Text(text)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreenUpdated() {
    val fakeProduct = Product("001", "Nike Air Max Preview", "Novedades", 1599.0, "tennislogo")
    TiendaTenisTheme {
        ProductDetailScreen(navController = rememberNavController(), product = fakeProduct)
    }
}
