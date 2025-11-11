package com.example.tiendatenis.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiendatenis.model.Product
import com.example.tiendatenis.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val apiService = RetrofitClient.apiService

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = apiService.getProducts()
                if (response.isSuccessful) {
                    _products.value = response.body() ?: emptyList()
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Error: ${response.code()}"
                    Log.e("HomeViewModel", "Error al cargar productos: ${response.code()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error de conexión: ${e.message}"
                Log.e("HomeViewModel", "Excepción al cargar productos", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getProductById(productId: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getProduct(productId)
                if (response.isSuccessful) {
                    _selectedProduct.value = response.body()
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error al obtener producto", e)
            }
        }
    }

    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            try {
                val response = apiService.deleteProduct(productId)
                if (response.isSuccessful) {
                    loadProducts() // Recargar lista
                } else {
                    _errorMessage.value = "Error al eliminar"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error de conexión"
                Log.e("HomeViewModel", "Error al eliminar producto", e)
            }
        }
    }

    suspend fun createProduct(product: Product): Boolean {
        return try {
            val response = apiService.createProduct(product)
            if (response.isSuccessful) {
                loadProducts()
                true
            } else {
                _errorMessage.value = "Error al crear producto"
                false
            }
        } catch (e: Exception) {
            _errorMessage.value = "Error de conexión"
            Log.e("HomeViewModel", "Error al crear producto", e)
            false
        }
    }

    suspend fun updateProduct(product: Product): Boolean {
        return try {
            val response = apiService.updateProduct(product.id, product)
            if (response.isSuccessful) {
                loadProducts()
                true
            } else {
                _errorMessage.value = "Error al actualizar"
                false
            }
        } catch (e: Exception) {
            _errorMessage.value = "Error de conexión"
            Log.e("HomeViewModel", "Error al actualizar producto", e)
            false
        }
    }
}
