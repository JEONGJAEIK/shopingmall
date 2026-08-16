package com.shop.core.user.service

import com.shop.core.user.entity.JoinRequest
import com.shop.core.user.entity.JoinResponse
import com.shop.core.user.jpa.UserInfo
import com.shop.core.user.repository.UserInfoJPARepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(private val userInfoJPARepo: UserInfoJPARepo) {

    @Transactional
    fun joinUser(joinRequest: JoinRequest) : JoinResponse {
        val newUserInfo = UserInfo.convertRequestToJpa(joinRequest)
        val save = userInfoJPARepo.save(newUserInfo)
        return save.covertJpaToResponse()
    }
}
