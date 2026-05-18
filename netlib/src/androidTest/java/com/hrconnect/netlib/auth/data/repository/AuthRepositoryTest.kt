package com.hrconnect.netlib.auth.data.repository

import com.google.common.truth.Truth.assertThat
import com.hrconnect.netlib.auth.domain.model.User
import com.hrconnect.netlib.auth.domain.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.inject

class AuthRepositoryTest : KoinTest {

    val authRepository: AuthRepository by inject()

    @Test
    fun login_returnsAuthResponse() = runBlocking {
        val authResponse = authRepository.login(
            username = "emilys",
            password = "emilyspass"
        ).getOrThrow()
        assertThat(authResponse.id).isEqualTo(1)
        assertThat(authResponse.email).isEqualTo("emily.johnson@x.dummyjson.com")
        assertThat(authResponse.firstName).isEqualTo("Emily")
        assertThat(authResponse.lastName).isEqualTo("Johnson")
        assertThat(authResponse.image).isEqualTo("https://dummyjson.com/icon/emilys/128")
        assertThat(authResponse.accessToken).isNotEmpty()
        assertThat(authResponse.refreshToken).isNotEmpty()
    }

    @Test
    fun getProfileByToken_returnsUser() = runBlocking {
        authRepository.login(
            username = "emilys",
            password = "emilyspass"
        )
        val mockUser = User(
            id = 1,
            email = "emily.johnson@x.dummyjson.com",
            firstName = "Emily",
            lastName = "Johnson",
            image = "https://dummyjson.com/icon/emilys/128",
            role = "admin"
        )
        val user = authRepository.getProfileByToken().getOrThrow()
        assertThat(user).isEqualTo(mockUser)
    }
}