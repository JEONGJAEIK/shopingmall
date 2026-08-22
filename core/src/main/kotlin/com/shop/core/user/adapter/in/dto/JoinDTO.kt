package com.shop.core.user.adapter.`in`.dto

import com.shop.core.user.application.JoinResult
import com.shop.core.user.domain.JoinRequest

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
        fun from(joinResult: JoinResult): JoinResponseDTO {
            return JoinResponseDTO(
                email = joinResult.user.email,
                username = joinResult.user.username,
                userId = joinResult.user.id,
                point = joinResult.userPoint.point
            )
        }
    }
}