package com.example.tiendatenis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

@Composable
fun AppDrawer(navController: NavController) {
    ModalDrawerSheet {
        // Sección del Perfil
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Perfil",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Mi perfil")
        }

        Divider() // Línea divisora

        // Lista de Opciones de Navegación
        Column(modifier = Modifier.padding(16.dp)) {
            // Dentro de @Composable fun AppDrawer(...)

// ...
            DrawerItem(icon = Icons.Default.Home, label = "Inicio", onClick = { navController.navigate("home") })
            DrawerItem(icon = Icons.Default.ShoppingCart, label = "Comprar", onClick = { navController.navigate("home") })
            DrawerItem(icon = Icons.Default.Delete, label = "Eliminar", onClick = { /* Lógica futura */ })
            DrawerItem(icon = Icons.Default.Edit, label = "Editar", onClick = { navController.navigate("edit_product") })
            DrawerItem(icon = Icons.Default.Add, label = "Agregar", onClick = { navController.navigate("add_product") })
            DrawerItem(icon = Icons.Default.Favorite, label = "Favoritos", onClick = { /* Lógica futura */ })
            DrawerItem(icon = Icons.Default.ExitToApp, label = "Cerrar Sesión", onClick = {
                // Navega al login y limpia el historial para que no pueda volver atrás
                navController.navigate("login") {
                    popUpTo(0)
                }
            })
        }
    }
}

@Composable
private fun DrawerItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(label)
            Spacer(modifier = Modifier.weight(1f)) // Empuja el texto a la izquierda
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppDrawer() {
    TiendaTenisTheme {
        AppDrawer(navController = rememberNavController())
    }
}