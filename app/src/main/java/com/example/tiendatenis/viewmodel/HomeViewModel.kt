package com.example.tiendatenis.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tiendatenis.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    // --- NUEVO ESTADO ---
    // Guardará el producto que el usuario seleccione
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()
    // --- FIN DEL NUEVO ESTADO ---


    init {
        loadProducts()
    }

    // --- NUEVA FUNCIÓN ---
    // Busca un producto en la lista por su ID
    fun getProductById(id: String) {
        val product = _products.value.find { it.id == id }
        _selectedProduct.update { product }
    }
    // --- FIN DE LA NUEVA FUNCIÓN ---

    private fun loadProducts() {
        val exampleProducts = listOf(
            Product("001", "Nike Air Max", "Novedades", 120.0, "tennislogo"),
            Product("002", "Adidas Ultraboost", "Nueva temporada", 180.0, "tennislogo"),
            Product("003", "Puma Suede", "Despídete de la temporada", 75.0, "tennislogo"),
            Product("004", "Reebok Classic", "Clásicos", 65.0, "tennislogo"),
            Product("005", "Vans Old Skool", "Skate", 60.0, "tennislogo")
        )
        _products.value = exampleProducts
    }
}