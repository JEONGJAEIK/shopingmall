package com.shop.core.user.controller.v1

import com.shop.core.user.dto.JoinRequestDTO
import com.shop.core.user.dto.JoinResponseDTO
import com.shop.core.user.entity.JoinRequest
import com.shop.core.user.service.JoinService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class JoinController(
    private val joinService: JoinService
) {

    @PostMapping("/join")
    fun joinUser(joinRequestDTO: JoinRequestDTO) : JoinResponseDTO {
        val joinRequest = joinRequestDTO.convertToEntity()
        val joinUser = joinService.joinUser(joinRequest)
        return JoinResponseDTO.convertToEntity(joinUser)
    }
}