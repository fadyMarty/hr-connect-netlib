package com.hrconnect.netlib.auth.data.mappers

import com.hrconnect.netlib.auth.data.remote.dto.UserDto
import com.hrconnect.netlib.auth.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        image = image,
        role = role
    )
}