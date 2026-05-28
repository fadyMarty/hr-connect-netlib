package com.hrconnect.netlib.common.util

import com.hrconnect.netlib.data.remote.AuthApi
import com.hrconnect.netlib.data.remote.dto.LoginRequestDto
import com.hrconnect.netlib.domain.manager.TokenManager
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Базовый класс для интеграционных API тестов.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
abstract class BaseApiTest : KoinTest {

    private val tokenManager: TokenManager by inject()
    protected val authApi: AuthApi by inject()

    /**
     * Функция для авторизации запросов и сохранения токена.
     */
    @Before
    fun authenticate() {
        return runBlocking {
            safeCall(
                tag = TAG,
                message = "Авторизация"
            ) {
                val authResponse = authApi.login(
                    request = LoginRequestDto(
                        username = "emilys",
                        password = "emilyspass"
                    )
                )
                tokenManager.saveToken(authResponse.accessToken)
            }
        }
    }

    companion object {
        private const val TAG = "BaseApiTest"
    }
}