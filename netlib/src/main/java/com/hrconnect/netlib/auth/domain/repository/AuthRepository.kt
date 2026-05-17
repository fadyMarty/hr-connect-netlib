package com.hrconnect.netlib.auth.domain.repository

interface AuthRepository {
    suspend fun login(): Result<Unit>
    suspend fun register(): Result<Unit>
    suspend fun getProfileByToken(): Result<Unit>
    suspend fun logout(): Result<Unit>
    suspend fun getAvatarById(id: String): Result<Unit>
}