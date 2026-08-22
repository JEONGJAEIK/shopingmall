package com.shop.core.user.application

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.adapter.out.jpa.UserEntity
import com.shop.core.user.adapter.out.jpa.UserPointEntity
import com.shop.core.user.adapter.out.repository.UserEntityJPARepo
import com.shop.core.user.adapter.out.repository.UserPointEntityJPARepo
import com.shop.core.user.domain.UserPoint
import com.shop.core.user.domain.Users
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateNewUserService(
    private val userEntityJPARepo: UserEntityJPARepo,
    private val userPointEntityJPARepo: UserPointEntityJPARepo,
) {

    @Transactional
    fun joinUser(joinRequest: JoinRequest): JoinResult {
        val saveUser = saveUser(joinRequest)
        val saveUserPoint = saveUserPoint(saveUser.id)
        return JoinResult(saveUser, saveUserPoint)
    }

    private fun saveUser(joinRequest: JoinRequest): Users {
        val newUserEntity = UserEntity.from(joinRequest)
        val save = userEntityJPARepo.save(newUserEntity)
        return save.toDomain()
    }

    private fun saveUserPoint(userId: Long): UserPoint {
        val userPointEntity = UserPointEntity.createNewUserPoint(userId)
        val savedPoint = userPointEntityJPARepo.save(userPointEntity)
        return savedPoint.toDomain()
    }
}

data class JoinResult (
    val user: Users,
    val userPoint: UserPoint
)

