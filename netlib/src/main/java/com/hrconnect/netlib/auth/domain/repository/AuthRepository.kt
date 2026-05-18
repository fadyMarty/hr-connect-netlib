package com.hrconnect.netlib.auth.domain.repository

import com.hrconnect.netlib.auth.domain.model.AuthResponse
import com.hrconnect.netlib.auth.domain.model.User

interface AuthRepository {
    suspend fun login(
        username: String,
        password: String,
        rememberUser: Boolean = true,
    ): Result<AuthResponse>
    suspend fun register(): Result<Unit>
    suspend fun getProfileByToken(): Result<User>
    suspend fun logout(): Result<Unit>
    suspend fun getAvatarById(id: String): Result<Unit>
}