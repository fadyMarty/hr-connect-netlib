package com.hrconnect.netlib.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val role: String,
)