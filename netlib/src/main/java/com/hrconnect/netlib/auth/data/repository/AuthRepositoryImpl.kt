package com.hrconnect.netlib.auth.data.repository

import com.hrconnect.netlib.auth.domain.manager.TokenManager
import com.hrconnect.netlib.auth.domain.repository.AuthRepository
import com.hrconnect.netlib.common.util.safeCall

class AuthRepositoryImpl(
    private val tokenManager: TokenManager,
) : AuthRepository {

    override suspend fun login(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Авторизация"
        ) {
            tokenManager.saveToken("")
        }
    }

    override suspend fun register(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Регистрация"
        ) {
            tokenManager.saveToken("")
        }
    }

    override suspend fun getProfileByToken(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Получение профиля по токену",
            execute = {}
        )
    }

    override suspend fun logout(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Выход"
        ) {
            tokenManager.deleteToken()
        }
    }

    override suspend fun getAvatarById(id: String): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Аватар пользователя",
            execute = {}
        )
    }

    companion object {
        private const val TAG = "AuthRepositoryImpl"
    }
}