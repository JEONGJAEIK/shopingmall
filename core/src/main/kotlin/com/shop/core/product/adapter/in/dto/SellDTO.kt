package com.shop.core.product.adapter.`in`.dto

import com.shop.core.product.domain.Product

data class SellRequestDTO(
    val sellerId: Long,
    val productName: String,
    val image: String,
    val description: String,
    val price: Double,
    val amount: Double
) {
    fun toProduct() : Product {
        return Product(
            sellerId = sellerId,
            productName = productName,
            image = image,
            description = description,
            price = price
        )
    }
}