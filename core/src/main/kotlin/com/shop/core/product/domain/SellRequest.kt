package com.shop.core.product.domain

data class Product (
    val sellerId: Long,
    val productName: String,
    val image: String,
    val description: String,
    val price: Double,
)