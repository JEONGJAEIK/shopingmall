package com.shop.core.user.adapter.`in`.dto

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.JoinResponse

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
        fun from(joinResponse: JoinResponse): JoinResponseDTO {
            return JoinResponseDTO(
                email = joinResponse.email,
                username = joinResponse.username,
                userId = joinResponse.userId,
                point = joinResponse.point
            )
        }
    }
}