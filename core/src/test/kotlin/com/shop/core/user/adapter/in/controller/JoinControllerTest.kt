package com.shop.core.user.adapter.`in`.controller

import com.shop.core.user.application.JoinService
import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.User
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(JoinController::class)
class JoinControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @MockitoBean
    private lateinit var joinService: JoinService

    @Test
    fun `비밀번호가_유출되지_않는가`() {
        val request = JoinRequest(
            email = "wodlr1207@gmail.com",
            password = "1234",
            username = "재익"
        )
        given(joinService.joinUser(request))
            .willReturn(
                User(
                    id = 1,
                    email = "wodlr1207@gmail.com",
                    password = "1234",
                    username = "재익"
                )
            )

        mockMvc.post("/user/join") {
            contentType = MediaType.APPLICATION_JSON
            content = """
                {
                    "email": "wodlr1207@gmail.com",
                    "password": "1234",
                    "username": "재익"
                }
            """.trimIndent()
        }.andDo {
            print()
        }.andExpect {
            status { isOk() }
            jsonPath("$.email") { value("wodlr1207@gmail.com")}
            jsonPath("$.password") { doesNotExist() }
        }
    }
}