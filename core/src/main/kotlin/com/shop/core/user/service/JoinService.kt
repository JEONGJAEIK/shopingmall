package com.shop.core.user.service

import com.shop.core.user.dto.JoinRequestDTO
import com.shop.core.user.entity.UserInfo
import com.shop.core.user.repository.UserInfoJPARepo
import org.springframework.stereotype.Service

@Service
class JoinService(private val userInfoJPARepo: UserInfoJPARepo) {

    fun joinUser(joinRequestDTO: JoinRequestDTO) {
        val firstUser = UserInfo.initJoin(
            joinRequestDTO.email,
            joinRequestDTO.password,
            joinRequestDTO.username
        )
        val save = userInfoJPARepo.save(firstUser)

    }
}
