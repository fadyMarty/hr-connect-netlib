package com.hrconnect.netlib.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * Модель пользователя.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
@Serializable
data class UserDto(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val role: String,
)