package com.hrconnect.netlib.auth.data.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("auth")
    suspend fun login()

    @POST("register")
    suspend fun register()

    @GET("auth/profileByToken")
    suspend fun getProfileByToken()

    @GET("logout")
    suspend fun logout()

    @GET("userAvatar")
    suspend fun getAvatarById(
        @Query("id") id: String,
    )
}