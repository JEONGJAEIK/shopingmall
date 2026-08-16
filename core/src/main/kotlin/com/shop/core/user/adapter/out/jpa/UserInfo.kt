package com.shop.core.user.adapter.out.jpa

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.User
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
    val userId: Long = 0,

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    var username: String = "",

    @Column(nullable = false)
    var point: Long = 0
) {
    fun toDomain(): User =
        User(
            email = this.email,
            username = this.username,
            id = this.userId,
            point = this.point,
            password = this.password
        )

    companion object {
        fun from(joinRequest: JoinRequest): UserInfo =
            UserInfo(
                email = joinRequest.email,
                username = joinRequest.username,
                password = joinRequest.password,
            )
    }
}