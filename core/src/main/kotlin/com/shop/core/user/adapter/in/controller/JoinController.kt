package com.shop.core.user.adapter.`in`.controller

import com.shop.core.user.adapter.`in`.dto.JoinRequestDTO
import com.shop.core.user.adapter.`in`.dto.JoinResponseDTO
import com.shop.core.user.application.CreateNewUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class JoinController(
    private val createNewUserService: CreateNewUserService
) {

    @PostMapping("/join")
    fun joinUser(@RequestBody joinRequestDTO: JoinRequestDTO) : ResponseEntity<JoinResponseDTO> {
        val joinRequest = joinRequestDTO.toJoinRequest()
        val joinResult = createNewUserService.joinUser(joinRequest)
        val joinResponseDTO = JoinResponseDTO.from(joinResult)
        return ResponseEntity.ok(joinResponseDTO)
    }
}