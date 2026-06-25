package com.shop.core.user.dto

data class JoinRequestDTO(
    val email: String,
    val password: String,
    val username: String
)

data class JoinResponseDTO(
    val userId: Long,
    val email: String,
    val username: String,
    val point: Int
)