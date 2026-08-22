package com.shop.core.user.adapter.out.repository

import com.shop.core.user.adapter.out.jpa.UserPointEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserPointEntityJPARepo : JpaRepository<UserPointEntity, Long> {

}