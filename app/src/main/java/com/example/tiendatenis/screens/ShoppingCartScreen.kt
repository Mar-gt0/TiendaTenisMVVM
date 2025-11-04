package com.example.tiendatenis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bolsa de compra") },
                navigationIcon = {
                    IconButton(onClick = { /* Lógica futura del menú */ }) {
                        Icon(Icons.Default.Menu, "Menú")
                    }
                },
                actions = {
                    IconButton(onClick = {}) { Icon(Icons.Default.Search, "Buscar") }
                    IconButton(onClick = {}) { Icon(Icons.Default.Person, "Perfil") }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("1 producto | $1599", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))

            CartItem()
            Spacer(modifier = Modifier.height(24.dp))

            ShippingInfo()
            Spacer(modifier = Modifier.height(24.dp))

            OrderSummary()
            Spacer(modifier = Modifier.weight(1f)) // Empuja el botón al final

            // --- ¡AQUÍ ESTÁ LA CORRECCIÓN! ---
            // El onClick ahora navega a la ruta "checkout"
            Button(
                onClick = { navController.navigate("checkout") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Finalizar compra")
            }
        }
    }
}

// --- El resto de los @Composable (CartItem, ShippingInfo, OrderSummary) ---
// --- no cambian. Pégalos aquí o déjalos como estaban. ---

@Composable
fun CartItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.tennislogo),
            contentDescription = "Tenis verdes",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text("$1599", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Tenis verdes", fontSize = 16.sp)
            Text("Talla 25", color = Color.Gray, fontSize = 14.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Gray)
            Text("1", fontSize = 16.sp)
            Icon(Icons.Default.Add, contentDescription = "Añadir", tint = Color.Black)
        }
    }
}

@Composable
fun ShippingInfo() {
    Column {
        Text("Envio gratuito", fontWeight = FontWeight.Bold)
        Text("Llega el jueves 9 de octubre", color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = "Ubicación", tint = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text("ubicacion", color = Color.Gray, modifier = Modifier.padding(top = 4.dp))
        }
    }
}

@Composable
fun OrderSummary() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Resumen de tu compra", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Subtotal", color = Color.Gray)
            Text("$ 1599")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Envio", color = Color.Gray)
            Text("gratis")
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Total", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("$1599", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewShoppingCartScreen() {
    TiendaTenisTheme {
        ShoppingCartScreen(navController = rememberNavController())
    }
}