package com.example.tiendatenis.model // El paquete que acabamos de crear

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String // (Por ahora usaremos 'tennislogo', pero esto lo prepara para el futuro)
)