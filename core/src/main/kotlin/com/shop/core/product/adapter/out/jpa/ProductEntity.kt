package com.shop.core.product.adapter.out.jpa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class ProductEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    val productId: Long = 0,

    @Column(name = "seller_id", nullable = false)
    var sellerId: Long,

    @Column(name = "product_name", nullable = false)
    var productName: String,

    @Column(name = "image", nullable = false)
    var image: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "price", nullable = false)
    var price: Double,
) {

}