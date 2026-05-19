package com.hrconnect.netlib.data.remote

import com.google.common.truth.Truth
import com.hrconnect.netlib.data.remote.BaseApiTest
import com.hrconnect.netlib.data.remote.dto.UserDto
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.test.inject

class AuthApiTest : BaseApiTest() {

    @Test
    fun login_returnsAuthResponse() = runBlocking {
        Truth.assertThat(authResponse.id).isEqualTo(1)
        Truth.assertThat(authResponse.email).isEqualTo("emily.johnson@x.dummyjson.com")
        Truth.assertThat(authResponse.firstName).isEqualTo("Emily")
        Truth.assertThat(authResponse.lastName).isEqualTo("Johnson")
        Truth.assertThat(authResponse.image).isEqualTo("https://dummyjson.com/icon/emilys/128")
        Truth.assertThat(authResponse.accessToken).isNotEmpty()
        Truth.assertThat(authResponse.refreshToken).isNotEmpty()
    }

    @Test
    fun getProfileByToken_returnsUser() = runBlocking {
        val mockUser = UserDto(
            id = 1,
            email = "emily.johnson@x.dummyjson.com",
            firstName = "Emily",
            lastName = "Johnson",
            image = "https://dummyjson.com/icon/emilys/128",
            role = "admin"
        )
        val user = authApi.getProfileByToken()

        Truth.assertThat(user).isEqualTo(mockUser)
    }
}