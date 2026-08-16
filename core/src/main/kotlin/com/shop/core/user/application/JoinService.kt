package com.shop.core.user.application

import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.JoinResponse
import com.shop.core.user.adapter.out.jpa.UserInfo
import com.shop.core.user.adapter.out.repository.UserInfoJPARepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(private val userInfoJPARepo: UserInfoJPARepo) {

    @Transactional
    fun joinUser(joinRequest: JoinRequest) : JoinResponse {
        val newUserInfo = UserInfo.from(joinRequest)
        val save = userInfoJPARepo.save(newUserInfo)
        return save.toJoinResponse()
    }
}
