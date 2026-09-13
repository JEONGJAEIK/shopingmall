package com.shop.core.product.adapter.`in`

import com.shop.core.product.adapter.`in`.dto.SellRequestDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class SellController {

    @PostMapping("/sell")
    fun sell(@RequestBody sellRequestDTO: SellRequestDTO) {
        val product = sellRequestDTO.toProduct()
    }
}