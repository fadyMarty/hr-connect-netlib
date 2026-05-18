package com.hrconnect.netlib.auth.data.repository

import com.hrconnect.netlib.auth.data.mappers.toAuthResponse
import com.hrconnect.netlib.auth.data.mappers.toUser
import com.hrconnect.netlib.auth.data.remote.AuthApi
import com.hrconnect.netlib.auth.data.remote.dto.LoginRequestDto
import com.hrconnect.netlib.auth.domain.manager.TokenManager
import com.hrconnect.netlib.auth.domain.model.AuthResponse
import com.hrconnect.netlib.auth.domain.model.User
import com.hrconnect.netlib.auth.domain.repository.AuthRepository
import com.hrconnect.netlib.common.util.safeCall

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val tokenManager: TokenManager,
) : AuthRepository {

    override suspend fun login(
        username: String,
        password: String,
        rememberUser: Boolean,
    ): Result<AuthResponse> {
        return safeCall(
            tag = TAG,
            message = "Авторизация"
        ) {
            val authResponse = authApi.login(
                request = LoginRequestDto(
                    username = username,
                    password = password
                )
            ).toAuthResponse()
            if (rememberUser) {
                tokenManager.saveToken(authResponse.accessToken)
            }
            authResponse
        }
    }

    override suspend fun register(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Регистрация"
        ) {
            authApi.register()
            tokenManager.saveToken("")
        }
    }

    override suspend fun getProfileByToken(): Result<User> {
        return safeCall(
            tag = TAG,
            message = "Получение профиля по токену"
        ) {
            authApi.getProfileByToken().toUser()
        }
    }

    override suspend fun logout(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Выход"
        ) {
            authApi.logout()
            tokenManager.deleteToken()
        }
    }

    override suspend fun getAvatarById(id: String): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Аватар пользователя"
        ) {
            authApi.getAvatarById(id)
        }
    }

    companion object {
        private const val TAG = "AuthRepositoryImpl"
    }
}