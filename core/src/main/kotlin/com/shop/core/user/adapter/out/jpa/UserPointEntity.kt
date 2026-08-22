package com.shop.core.user.adapter.out.jpa

import com.shop.core.user.domain.UserPoint
import jakarta.persistence.*


@Entity
@Table(name = "user_point")
class UserPointEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var userId: Long = 0,

    @Column(nullable = false)
    var point: Long = 0
) {
    fun toDomain(): UserPoint =
        UserPoint(
            id = this.id,
            userId = this.userId,
            point = this.point
        )

    companion object {
        fun createNewUserPoint(userId: Long): UserPointEntity =
            UserPointEntity(
                userId = userId,
            )
    }
}