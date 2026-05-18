package com.hrconnect.netlib.auth.data.remote.dto

import kotlinx.serialization.Serializable

enum class Role {
    ADMIN
}

@Serializable
data class UserDto(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val role: String,
)