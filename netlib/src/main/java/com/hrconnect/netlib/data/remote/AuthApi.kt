package com.hrconnect.netlib.data.remote

import com.hrconnect.netlib.data.remote.dto.AuthResponseDto
import com.hrconnect.netlib.data.remote.dto.LoginRequestDto
import com.hrconnect.netlib.data.remote.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * API-интерфейс для работы с авторизацией и профилем пользователя.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface AuthApi {

    /**
     * Авторизация.
     *
     * @param request модель запроса авторизации.
     *
     * @return модель ответа авторизации.
     */
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequestDto,
    ): AuthResponseDto

    /**
     * Регистрация.
     */
    @POST("register")
    suspend fun register()

    /**
     * Получение профиля по токену.
     *
     * @return модель пользователя.
     */
    @GET("auth/me")
    suspend fun getProfileByToken(): UserDto

    /**
     * Выход.
     */
    @GET("logout")
    suspend fun logout()

    /**
     * Аватар пользователя.
     *
     * @param id идентификатор пользователя.
     */
    @GET("userAvatar")
    suspend fun getAvatarById(
        @Query("id") id: String,
    )
}