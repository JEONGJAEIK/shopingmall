package com.shop.core.user.domain

data class JoinRequest(
    val email: String,
    val password: String,
    val username: String
)

data class JoinResponse(
    val email: String,
    val username: String,
    val userId: Long,
    val point: Long
)
