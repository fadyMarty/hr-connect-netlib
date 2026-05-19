package com.hrconnect.netlib.data.remote

import com.hrconnect.netlib.data.manager.TokenManager
import com.hrconnect.netlib.data.remote.dto.AuthResponseDto
import com.hrconnect.netlib.data.remote.dto.LoginRequestDto
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.koin.test.KoinTest
import org.koin.test.inject

abstract class BaseApiTest : KoinTest {

    private val tokenManager: TokenManager by inject()
    protected val authApi: AuthApi by inject()
    protected lateinit var authResponse: AuthResponseDto

    @Before
    fun authenticate() = runBlocking {
        authResponse = authApi.login(
            request = LoginRequestDto(
                username = "emilys",
                password = "emilyspass"
            )
        )
        tokenManager.saveToken(authResponse.accessToken)
    }
}