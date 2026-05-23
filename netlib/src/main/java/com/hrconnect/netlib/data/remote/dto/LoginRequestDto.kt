package com.hrconnect.netlib.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * Модель запроса авторизации.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
@Serializable
data class LoginRequestDto(
    val username: String,
    val password: String,
)
