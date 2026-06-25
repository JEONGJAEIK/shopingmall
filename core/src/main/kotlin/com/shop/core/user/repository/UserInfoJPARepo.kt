package com.shop.core.user.repository

import com.shop.core.user.entity.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoJPARepo : JpaRepository<UserInfo, Long?> {

}