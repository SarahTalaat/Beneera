package com.example.beneera.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Categories : Screen("categories")
    object CategoryDetail : Screen("category/{categoryId}") {
        fun createRoute(categoryId: String) = "category/$categoryId"
    }
    object ProductDetail : Screen("product/{productId}") {
        fun createRoute(productId: String) = "product/$productId"
    }
    object Cart : Screen("cart")
    object Checkout : Screen("checkout")
    object OrderConfirmation : Screen("order_confirmation")
    object Search : Screen("search")
    object About : Screen("about")
    object ShippingPolicy : Screen("shipping_policy")
    object ReturnsPolicy : Screen("returns_policy")
    object PrivacyPolicy : Screen("privacy_policy")
    object TermsConditions : Screen("terms_conditions")
    object Accessibility : Screen("accessibility")
    object Contact : Screen("contact")
}
