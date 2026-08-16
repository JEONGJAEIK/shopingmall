package com.shop.core.user.adapter.out.repository

import com.shop.core.user.adapter.out.jpa.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoJPARepo : JpaRepository<UserInfo, Long> {

}