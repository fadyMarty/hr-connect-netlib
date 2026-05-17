package com.hrconnect.netlib.auth.domain.manager

import kotlinx.coroutines.flow.Flow

interface TokenManager {
    fun getToken(): Flow<String?>
    suspend fun saveToken(token: String)
    suspend fun deleteToken()
}