package com.example.tiendatenis.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiendatenis.database.DatabaseHelper
import com.example.tiendatenis.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val dbHelper = DatabaseHelper(application)

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _products.value = dbHelper.getAllProducts()
        }
    }

    fun getProductById(productId: String) {
        viewModelScope.launch {
            _selectedProduct.value = _products.value.find { it.id == productId }
        }
    }

    fun insertSampleProducts() {
        viewModelScope.launch {
            dbHelper.insertSampleProducts()
            loadProducts()
        }
    }
    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            dbHelper.deleteProduct(productId)
            loadProducts()
        }
    }

    fun getProductByIdForEdit(productId: String): Product? {
        return dbHelper.getProductById(productId)
    }

}
