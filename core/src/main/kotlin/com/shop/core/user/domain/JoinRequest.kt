package com.shop.core.user.domain

data class JoinRequest(
    val email: String,
    val password: String,
    val username: String
)