package com.example.beneera.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beneera.data.CartItem
import com.example.beneera.data.Order
import com.example.beneera.ui.screens.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    var cartItems by remember { mutableStateOf(listOf<CartItem>()) }
    var lastOrder by remember { mutableStateOf<Order?>(null) }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                },
                onCategoryClick = { categoryId ->
                    navController.navigate(Screen.CategoryDetail.createRoute(categoryId))
                },
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                },
                onCartClick = {
                    navController.navigate(Screen.Cart.route)
                },
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(
            route = Screen.CategoryDetail.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            CategoryCatalogScreen(
                categoryId = categoryId,
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                },
                onBackClick = { navController.popBackStack() },
                onSearchClick = { navController.navigate(Screen.Search.route) },
                onCartClick = { navController.navigate(Screen.Cart.route) }
            )
        }

        composable(
            route = Screen.ProductDetail.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailScreen(
                productId = productId,
                onBackClick = { navController.popBackStack() },
                onCartClick = { navController.navigate(Screen.Cart.route) },
                onProductClick = { newProductId ->
                    navController.navigate(Screen.ProductDetail.createRoute(newProductId))
                },
                onAddToCart = { cartItem ->
                    val existingIndex = cartItems.indexOfFirst { 
                        it.product.id == cartItem.product.id && it.selectedVariant == cartItem.selectedVariant 
                    }
                    if (existingIndex >= 0) {
                        cartItems = cartItems.toMutableList().also {
                            it[existingIndex] = it[existingIndex].copy(quantity = it[existingIndex].quantity + cartItem.quantity)
                        }
                    } else {
                        cartItems = cartItems + cartItem
                    }
                }
            )
        }

        composable(Screen.Cart.route) {
            CartScreen(
                cartItems = cartItems,
                onUpdateQuantity = { item, newQty ->
                    cartItems = cartItems.map {
                        if (it.product.id == item.product.id && it.selectedVariant == item.selectedVariant) {
                            it.copy(quantity = newQty)
                        } else {
                            it
                        }
                    }
                },
                onRemoveItem = { item ->
                    cartItems = cartItems.filterNot { 
                        it.product.id == item.product.id && it.selectedVariant == item.selectedVariant 
                    }
                },
                onBackClick = { navController.popBackStack() },
                onCheckoutClick = { navController.navigate(Screen.Checkout.route) },
                onContinueShopping = { navController.popBackStack() }
            )
        }

        composable(Screen.Checkout.route) {
            CheckoutScreen(
                cartItems = cartItems,
                onBackClick = { navController.popBackStack() },
                onOrderPlaced = { order ->
                    lastOrder = order
                    cartItems = emptyList() // clear cart on successful order
                },
                onReturnHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Search.route) {
            SearchScreen(
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.About.route) {
            InfoScreen(title = "About Us", content = PolicyContents.aboutUs, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.ShippingPolicy.route) {
            InfoScreen(title = "Shipping Policy", content = PolicyContents.shippingPolicy, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.ReturnsPolicy.route) {
            InfoScreen(title = "Returns & Refunds", content = PolicyContents.returnsPolicy, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.PrivacyPolicy.route) {
            InfoScreen(title = "Privacy Policy", content = PolicyContents.privacyPolicy, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.TermsConditions.route) {
            InfoScreen(title = "Terms & Conditions", content = PolicyContents.termsConditions, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.Accessibility.route) {
            InfoScreen(title = "Accessibility", content = PolicyContents.accessibility, onBackClick = { navController.popBackStack() })
        }
        composable(Screen.Contact.route) {
            ContactScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
