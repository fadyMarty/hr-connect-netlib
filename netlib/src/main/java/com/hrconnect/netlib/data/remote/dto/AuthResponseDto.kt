package com.hrconnect.netlib.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * Модель ответа авторизации.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
@Serializable
data class AuthResponseDto(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val accessToken: String,
    val refreshToken: String,
)