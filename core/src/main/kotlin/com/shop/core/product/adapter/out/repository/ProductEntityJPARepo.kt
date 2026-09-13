package com.shop.core.product.adapter.out.repository

import com.shop.core.product.adapter.out.jpa.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductEntityJPARepo : JpaRepository<ProductEntity, Long> {
}