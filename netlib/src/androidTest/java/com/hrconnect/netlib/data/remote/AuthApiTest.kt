package com.hrconnect.netlib.data.remote

import com.hrconnect.netlib.common.util.BaseApiTest
import com.hrconnect.netlib.common.util.safeCall
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Класс с тестами для проверки работы API-интерфейса авторизации.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
class AuthApiTest : BaseApiTest() {

    /**
     * Тест выполнения запроса авторизации.
     */
    @Test
    fun login() {
        // Запрос выполняется в BaseApiTest
    }

    /**
     * Тест выполнения запроса получения профиля по токену.
     */
    @Test
    fun getProfileByToken() {
        return runBlocking {
            safeCall(
                tag = TAG,
                message = "Получение профиля по токену"
            ) {
                authApi.getProfileByToken()
            }
        }
    }

    companion object {
        private const val TAG = "AuthApiTest"
    }
}