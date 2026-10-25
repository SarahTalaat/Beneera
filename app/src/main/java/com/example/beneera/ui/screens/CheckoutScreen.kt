package com.example.beneera.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beneera.data.Address
import com.example.beneera.data.CartItem
import com.example.beneera.data.Order
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(
    cartItems: List<CartItem>,
    onBackClick: () -> Unit,
    onOrderPlaced: (Order) -> Unit,
    onReturnHome: () -> Unit
) {
    var fullName by remember { mutableStateOf("Sarah Johnson") }
    var street by remember { mutableStateOf("742 Evergreen Terrace") }
    var city by remember { mutableStateOf("Springfield") }
    var state by remember { mutableStateOf("OR") }
    var zipCode by remember { mutableStateOf("97477") }
    var email by remember { mutableStateOf("sarah.johnson@example.com") }
    var phone by remember { mutableStateOf("555-0199") }
    
    var paymentMethod by remember { mutableStateOf("Credit Card") }
    var isSubmitted by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val subtotal = cartItems.sumOf { it.product.price * it.quantity }
    val shipping = if (subtotal >= 49.0) 0.0 else 5.99
    val total = subtotal + shipping

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = if (isSubmitted) "Order Confirmation" else "Checkout", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    if (!isSubmitted) {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (isSubmitted) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(0xFF388E3C),
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Order Placed Successfully!", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Thank you for shopping with Beneera. We've sent a confirmation email to $email.",
                        color = Color.Gray,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        shadowElevation = 2.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Order Summary", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Shipping Address:", fontWeight = FontWeight.Medium, fontSize = 13.sp, color = Color.Gray)
                            Text(text = "$fullName\n$street, $city, $state $zipCode", fontSize = 13.sp)
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = "Total Paid: $${String.format("%.2f", total)}", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = MaterialTheme.colorScheme.primary)
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = onReturnHome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Back to Homepage", fontWeight = FontWeight.Bold)
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = "Shipping Information", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text("Full Name") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = street,
                        onValueChange = { street = it },
                        label = { Text("Street Address") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = city,
                            onValueChange = { city = it },
                            label = { Text("City") },
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = state,
                            onValueChange = { state = it },
                            label = { Text("State") },
                            modifier = Modifier.weight(0.5f),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = zipCode,
                            onValueChange = { zipCode = it },
                            label = { Text("ZIP Code") },
                            modifier = Modifier.weight(0.8f),
                            singleLine = true
                        )
                    }
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone Number") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Payment Simulation", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(),
                        shadowElevation = 1.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "🔒 Secure Simulated Payment (No real charges)", fontSize = 12.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedTextField(
                                value = "4242 •••• •••• 4242",
                                onValueChange = {},
                                label = { Text("Card Number") },
                                modifier = Modifier.fillMaxWidth(),
                                enabled = false
                            )
                        }
                    }

                    if (errorMessage.isNotBlank()) {
                        Text(text = errorMessage, color = Color.Red, fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if (fullName.isBlank() || street.isBlank() || city.isBlank() || state.isBlank() || zipCode.isBlank() || email.isBlank()) {
                                errorMessage = "Please fill in all required shipping fields."
                            } else {
                                errorMessage = ""
                                val order = Order(
                                    orderId = "BEN-" + UUID.randomUUID().toString().take(6).uppercase(),
                                    items = cartItems,
                                    subtotal = subtotal,
                                    shipping = shipping,
                                    total = total,
                                    shippingAddress = Address(fullName, street, city, state, zipCode, email, phone),
                                    orderDate = "Today"
                                )
                                onOrderPlaced(order)
                                isSubmitted = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Place Order ($${String.format("%.2f", total)})", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}
