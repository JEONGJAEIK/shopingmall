package com.shop.core.user.adapter.`in`.dto

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.User

data class JoinRequestDTO(
    val email: String,
    val password: String,
    val username: String
) {
    fun toJoinRequest(): JoinRequest {
        return JoinRequest(
            email = this.email,
            username = this.username,
            password = this.password
        )
    }
}

data class JoinResponseDTO(
    val userId: Long,
    val email: String,
    val username: String,
    val point: Long
) {
    companion object {
        fun from(user: User): JoinResponseDTO {
            return JoinResponseDTO(
                email = user.email,
                username = user.username,
                userId = user.id,
                point = user.point
            )
        }
    }
}