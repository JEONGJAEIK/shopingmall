package com.shop.core.user.entity

data class JoinRequest(
    val email: String,
    val password: String,
    val username: String
) {
    companion object {
        fun convertToEntity(email: String, username: String, password: String) : JoinRequest{
            return JoinRequest(email, username, password)
        }
    }
}
