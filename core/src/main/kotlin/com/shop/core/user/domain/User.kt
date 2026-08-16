package com.shop.core.user.domain

class User (
    val id: Long = 0,
    val email: String,
    val username: String,
    val password: String,
    val point: Long = 0
)