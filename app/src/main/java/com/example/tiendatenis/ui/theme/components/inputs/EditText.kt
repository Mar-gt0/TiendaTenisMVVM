package com.example.tiendatenis.ui.theme.texts

import androidx.compose.material3.Text
import androidx.compose.material3.TextField // 1. Importa el TextField real
import androidx.compose.runtime.Composable

@Composable
fun EditText(label: String, onValueChange: (String) -> Unit, value: String) { // 2. onValueChange debe recibir un String
    // 3. Llama al TextField de Material, no a ti mismo
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) } // 4. Usa el Text estándar aquí
    )
}