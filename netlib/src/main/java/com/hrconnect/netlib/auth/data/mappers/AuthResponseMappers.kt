package com.hrconnect.netlib.auth.data.mappers

import com.hrconnect.netlib.auth.data.remote.dto.AuthResponseDto
import com.hrconnect.netlib.auth.domain.model.AuthResponse

fun AuthResponseDto.toAuthResponse(): AuthResponse {
    return AuthResponse(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        image = image,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}