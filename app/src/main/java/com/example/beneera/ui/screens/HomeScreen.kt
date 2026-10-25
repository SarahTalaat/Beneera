package com.example.beneera.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beneera.data.BeneeraRepository
import com.example.beneera.data.Category
import com.example.beneera.data.Product
import com.example.beneera.ui.components.ProductCard
import com.example.beneera.ui.components.SectionHeader
import com.example.beneera.util.ImageMapper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProductClick: (String) -> Unit,
    onCategoryClick: (String) -> Unit,
    onSearchClick: () -> Unit,
    onCartClick: () -> Unit,
    onNavigate: (String) -> Unit
) {
    var newsletterEmail by remember { mutableStateOf("") }
    var newsletterSubscribed by remember { mutableStateOf(false) }
    val heroResId = ImageMapper.getHeroDrawable()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "BENEERA",
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = onCartClick) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Announcement Bar
            Surface(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "🐾 Free US Shipping on Orders Over $49! Shop Pet Essentials Today 🐾",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }

            // Hero Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = heroResId),
                    contentDescription = "Happy Pets",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Everything Your Pet Loves",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Premium quality food, cozy beds, toys, and grooming essentials for happy dogs and cats.",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Button(
                        onClick = { onCategoryClick("dog-supplies") },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Shop Best Sellers", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Categories Section
            SectionHeader(title = "Shop by Category", subtitle = "Explore our wide range of pet supplies")
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(BeneeraRepository.categories) { category ->
                    CategoryItemCard(category = category, onClick = { onCategoryClick(category.id) })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Featured Products
            SectionHeader(title = "Featured Products", subtitle = "Top rated favorites for your furry friends", onSeeAllClick = { onCategoryClick("dog-supplies") })
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(BeneeraRepository.products.filter { it.isFeatured }) { product ->
                    ProductCard(product = product, onClick = { onProductClick(product.id) })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Trust Badges Banner
            Surface(
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TrustFeature(icon = Icons.Default.LocalShipping, title = "Free Shipping", subtitle = "On orders over $49")
                    TrustFeature(icon = Icons.Default.Security, title = "Secure Checkout", subtitle = "100% Protected")
                    TrustFeature(icon = Icons.Default.SupportAgent, title = "24/7 Support", subtitle = "Expert assistance")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // New Arrivals
            SectionHeader(title = "New Arrivals", subtitle = "Fresh drops for happy pets", onSeeAllClick = { onCategoryClick("cat-supplies") })
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(BeneeraRepository.products.filter { it.isNewArrival }) { product ->
                    ProductCard(product = product, onClick = { onProductClick(product.id) })
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Newsletter Section
            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Join the Beneera Pet Club",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Subscribe for 15% off your first order, expert pet care tips, and exclusive deals.",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (newsletterSubscribed) {
                        Surface(
                            color = Color(0xFFE8F5E9),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "🎉 Thank you for subscribing! Check your email for your 15% off code.",
                                color = Color(0xFF2E7D32),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(12.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    } else {
                        OutlinedTextField(
                            value = newsletterEmail,
                            onValueChange = { newsletterEmail = it },
                            placeholder = { Text("Enter your email address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                if (newsletterEmail.isNotBlank() && newsletterEmail.contains("@")) {
                                    newsletterSubscribed = true
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Subscribe Now", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Footer
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(24.dp)
            ) {
                Text(
                    text = "BENEERA",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Quality essentials for pets and families. Reliable customer support, secure shopping, and transparent shipping.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(text = "Quick Links", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Text(text = "About Us", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("about") })
                        Text(text = "Contact Us", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("contact") })
                        Text(text = "Shipping Policy", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("shipping_policy") })
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(text = "Policies", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Text(text = "Returns & Refunds", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("returns_policy") })
                        Text(text = "Privacy Policy", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("privacy_policy") })
                        Text(text = "Terms & Conditions", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("terms_conditions") })
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(text = "Support", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Text(text = "Accessibility", fontSize = 12.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { onNavigate("accessibility") })
                        Text(text = "FAQ", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "© 2025 Beneera Inc. All rights reserved.",
                    fontSize = 11.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun CategoryItemCard(category: Category, onClick: () -> Unit) {
    val drawableRes = remember(category.id) {
        ImageMapper.getCategoryDrawable(category.id)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = drawableRes),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = category.name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            maxLines = 2,
            lineHeight = 14.sp
        )
    }
}

@Composable
fun TrustFeature(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontSize = 11.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text(text = subtitle, fontSize = 9.sp, color = Color.Gray, textAlign = TextAlign.Center)
    }
}
