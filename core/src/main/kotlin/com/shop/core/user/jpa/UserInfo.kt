package com.shop.core.user.jpa

import com.shop.core.user.entity.JoinRequest
import com.shop.core.user.entity.JoinResponse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "user_info")
class UserInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    var username: String = "",

    @Column(nullable = false)
    var point: Long = 0
) {
    fun covertJpaToResponse(): JoinResponse =
        JoinResponse(
            email = this.email,
            username = this.username,
            userId = this.userId,
            point = this.point
        )

    companion object {
        fun convertRequestToJpa(joinRequest: JoinRequest): UserInfo =
            UserInfo(
                email = joinRequest.email,
                username = joinRequest.username,
                password = joinRequest.password,
            )
    }
}