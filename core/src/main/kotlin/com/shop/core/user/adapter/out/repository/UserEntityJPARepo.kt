package com.shop.core.user.adapter.out.repository

import com.shop.core.user.adapter.out.jpa.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserEntityJPARepo : JpaRepository<UserEntity, Long> {

}