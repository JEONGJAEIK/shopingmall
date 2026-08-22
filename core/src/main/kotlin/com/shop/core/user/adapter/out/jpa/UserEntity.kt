package com.shop.core.user.adapter.out.jpa

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.Users
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType


@Entity
@Table(name = "user_info")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long = 0,

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false, unique = true)
    var username: String = "",

) {
    fun toDomain(): Users =
        Users(
            email = this.email,
            username = this.username,
            id = this.userId,
            password = this.password
        )

    companion object {
        fun from(joinRequest: JoinRequest): UserEntity =
            UserEntity(
                email = joinRequest.email,
                username = joinRequest.username,
                password = joinRequest.password,
            )
    }
}