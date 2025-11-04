package com.example.tiendatenis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tiendatenis.navigation.AppNavigation // <-- ¡Importamos el Mapa!
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TiendaTenisTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // ¡Y aquí llamamos al Mapa!
                    AppNavigation()
                }
            }
        }
    }
}