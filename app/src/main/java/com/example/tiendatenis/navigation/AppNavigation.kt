package com.example.tiendatenis.navigation

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.tiendatenis.screens.*
import com.example.tiendatenis.viewmodel.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(navController = navController, viewModel = loginViewModel)
        }

        composable("home") {
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }

        composable(
            route = "detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            if (productId != null) {
                homeViewModel.getProductById(productId)
            }
            val selectedProduct by homeViewModel.selectedProduct.collectAsState()
            ProductDetailScreen(navController = navController, product = selectedProduct)
        }

        composable("register") { RegistrationScreen() }
        composable("forgot_password") { RecuContraScreen() }
        composable("forgot_password_2") { RecuContra2Screen() }

        // --- RUTAS CRUD ---
        composable("add_product") {
            AddProductScreen(navController = navController)
        }
        composable("edit_product") {
            EditProductScreen(navController = navController)
        }

  
        composable("cart") {
            ShoppingCartScreen(navController = navController)
        }

        composable("checkout") {
            CheckoutScreen(navController = navController)
        }

        composable("purchase_success") {
            PurchaseSuccessScreen(navController = navController)
        }
    }
}
