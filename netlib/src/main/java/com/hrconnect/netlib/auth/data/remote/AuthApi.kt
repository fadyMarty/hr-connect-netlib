package com.hrconnect.netlib.auth.data.remote

import com.hrconnect.netlib.auth.data.remote.dto.AuthResponseDto
import com.hrconnect.netlib.auth.data.remote.dto.LoginRequestDto
import com.hrconnect.netlib.auth.data.remote.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequestDto,
    ): AuthResponseDto

    @POST("register")
    suspend fun register()

    @GET("auth/me")
    suspend fun getProfileByToken(): UserDto

    @GET("logout")
    suspend fun logout()

    @GET("userAvatar")
    suspend fun getAvatarById(
        @Query("id") id: String,
    )
}