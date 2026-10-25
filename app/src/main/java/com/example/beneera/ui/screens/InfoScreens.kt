package com.example.beneera.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    title: String,
    content: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
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
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                lineHeight = 24.sp
            )
        }
    }
}

object PolicyContents {
    const val aboutUs = """
Welcome to Beneera! We are passionate about providing premium-quality pet essentials that enrich the lives of dogs, cats, and the families who love them.

Founded with a commitment to reliability, transparent pricing, and exceptional customer care, Beneera curates top-tier products ranging from orthopedic memory foam beds and stainless steel water fountains to engaging toys and gentle grooming equipment.

Our mission is simple: Make pet parenting easier, joyful, and affordable across the United States. Thank you for trusting Beneera as your partner in pet care.
"""

    const val shippingPolicy = """
At Beneera, we strive to deliver your pet essentials as quickly and safely as possible.

• Free US Shipping on all orders over $49.
• Standard Shipping: $5.99 for orders under $49. Delivery typically takes 3-5 business days.
• Processing Time: Orders are processed within 24-48 hours Monday through Friday.
• Carrier Partners: We ship via USPS, FedEx, and UPS with tracking provided for every order.
"""

    const val returnsPolicy = """
We want you and your pet to be 100% satisfied with your Beneera purchase.

• 30-Day Return Window: If you are not completely satisfied, you may return unused items in their original packaging within 30 days of delivery for a full refund.
• Easy Return Process: Contact our support team at support@beneera.com to initiate a return.
• Return Shipping: Customers are responsible for return shipping costs unless the item arrived damaged or defective.
• Refunds are processed within 3-5 business days upon receipt and inspection of the returned merchandise.
"""

    const val privacyPolicy = """
Beneera respects your privacy and is committed to protecting your personal data.

• Information We Collect: Name, shipping address, email address, and phone number when you place an order or subscribe to our newsletter.
• How We Use Your Data: To fulfill orders, communicate shipping updates, and provide customer support.
• Data Security: We use industry-standard encryption (SSL) for secure checkout. We never sell or share your personal information with third-party advertisers.
"""

    const val termsConditions = """
By accessing and shopping at Beneera.com, you agree to the following terms and conditions:

• Use of Site: All content, images, and product descriptions are the property of Beneera.
• Pricing & Availability: Prices and product availability are subject to change without notice. We reserve the right to correct any pricing errors.
• Limitation of Liability: Beneera is not liable for indirect or consequential damages arising from product usage. Always follow product safety instructions for your pets.
"""

    const val accessibility = """
Beneera is committed to ensuring digital accessibility for people with disabilities.

• Standards: We strive to adhere to WCAG 2.1 AA accessibility guidelines across our mobile and web platforms.
• Feedback: If you encounter any accessibility barriers while using our app or website, please contact us at support@beneera.com so we can continuously improve our user experience.
"""
}
