package com.example.tiendatenis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tiendatenis.database.DatabaseHelper
import com.example.tiendatenis.navigation.AppNavigation
import com.example.tiendatenis.ui.theme.TiendaTenisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Insertar 5 productos de prueba solo la primera vez
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val isFirstRun = prefs.getBoolean("is_first_run", true)

        if (isFirstRun) {
            val dbHelper = DatabaseHelper(this)
            dbHelper.insertSampleProducts()
            prefs.edit().putBoolean("is_first_run", false).apply()
        }

        setContent {
            TiendaTenisTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}
