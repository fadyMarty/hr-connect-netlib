package com.hrconnect.netlib.auth.data.remote.dto

import kotlinx.serialization.Serializable

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