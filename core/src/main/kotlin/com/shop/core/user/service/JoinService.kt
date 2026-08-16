package com.shop.core.user.service

import com.shop.core.user.entity.JoinRequest
import com.shop.core.user.jpa.UserInfo
import com.shop.core.user.repository.UserInfoJPARepo
import org.springframework.stereotype.Service

@Service
class JoinService(private val userInfoJPARepo: UserInfoJPARepo) {

    fun joinUser(joinRequest: JoinRequest) {
        val newUserInfo = UserInfo.initJoin(joinRequest)
        val save = userInfoJPARepo.save(newUserInfo)

    }
}
