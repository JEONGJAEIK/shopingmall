package com.shop.core.user.jpa

import com.shop.core.user.entity.JoinEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

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
    var point: Int = 0

) {
    companion object {
        fun initJoin(joinRequest: JoinEntity) : UserInfo =
            UserInfo(
                email = joinRequest.email,
                username = joinRequest.username,
                password = joinRequest.password,
            )
    }
}