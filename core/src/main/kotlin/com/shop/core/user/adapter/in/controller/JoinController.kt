package com.shop.core.user.adapter.`in`.controller

import com.shop.core.user.adapter.`in`.dto.JoinRequestDTO
import com.shop.core.user.adapter.`in`.dto.JoinResponseDTO
import com.shop.core.user.application.JoinService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class JoinController(
    private val joinService: JoinService
) {

    @PostMapping("/join")
    fun joinUser(joinRequestDTO: JoinRequestDTO) : ResponseEntity<JoinResponseDTO> {
        val joinRequest = joinRequestDTO.convertToEntity()
        val joinUser = joinService.joinUser(joinRequest)
        val joinResponseDTO = JoinResponseDTO.convertToEntity(joinUser)
        return ResponseEntity.ok(joinResponseDTO)
    }
}