package com.shop.core.user.adapter.`in`.controller

import com.shop.core.user.application.CreateNewUserService
import com.shop.core.user.application.JoinResult
import com.shop.core.user.domain.JoinRequest
import com.shop.core.user.domain.UserPoint
import com.shop.core.user.domain.Users
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
    private lateinit var createNewUserService: CreateNewUserService

    @Test
    fun `비밀번호가_유출되지_않는가`() {
        val request = JoinRequest(
            email = "wodlr1207@gmail.com",
            password = "1234",
            username = "재익"
        )
        given(createNewUserService.joinUser(request))
            .willReturn(
                JoinResult(
                    user = Users(
                        id = 1,
                        email = "wodlr1207@gmail.com",
                        password = "1234",
                        username = "재익"
                    ),
                    userPoint = UserPoint(
                        id = 1,
                        userId = 1,
                        point = 0
                    )
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
            jsonPath("$.point") { value(0) }
            jsonPath("$.password") { doesNotExist() }
        }
    }
}