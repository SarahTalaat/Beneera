package com.example.beneera.data

data class Product(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
    val originalPrice: Double? = null,
    val rating: Double = 4.8,
    val reviewCount: Int = 124,
    val imageUrl: String,
    val description: String,
    val specifications: List<Pair<String, String>>,
    val variants: List<String> = emptyList(),
    val isFeatured: Boolean = false,
    val isNewArrival: Boolean = false,
    val isOnSale: Boolean = false,
    val inStock: Boolean = true
)

data class CartItem(
    val product: Product,
    val selectedVariant: String?,
    val quantity: Int
)

data class Order(
    val orderId: String,
    val items: List<CartItem>,
    val subtotal: Double,
    val shipping: Double,
    val total: Double,
    val shippingAddress: Address,
    val orderDate: String
)

data class Address(
    val fullName: String,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val email: String,
    val phone: String
)

data class Category(
    val id: String,
    val name: String,
    val description: String,
    val iconName: String,
    val imageUrl: String
)
