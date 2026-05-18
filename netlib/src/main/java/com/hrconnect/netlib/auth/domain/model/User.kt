package com.hrconnect.netlib.auth.domain.model

data class User(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val role: String,
)