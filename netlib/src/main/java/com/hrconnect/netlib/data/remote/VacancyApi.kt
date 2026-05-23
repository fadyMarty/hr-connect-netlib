package com.hrconnect.netlib.data.remote

import okhttp3.MultipartBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

/**
 * API-интерфейс для работы с вакансиями.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface VacancyApi {

    /**
     * Список вакансий.
     */
    @GET("vacancy")
    suspend fun getVacancies()

    /**
     * Создание вакансии.
     */
    @POST("vacancy")
    suspend fun createVacancy()

    /**
     * Вакансия по ID.
     *
     * @param id идентификатор вакансии.
     */
    @POST("vacancy/{id}")
    suspend fun getVacancyById(
        @Path("id") id: String,
    )

    /**
     * Редактирование вакансии.
     *
     * @param id идентификатор вакансии.
     */
    @PUT("vacancy/{id}")
    suspend fun updateVacancy(
        @Path("id") id: String,
    )

    /**
     * Удаление вакансии.
     *
     * @param id идентификатор вакансии.
     */
    @DELETE("vacancy/{id}")
    suspend fun deleteVacancy(
        @Path("id") id: String,
    )

    /**
     * Загрузка файлов вакансии.
     *
     * @param id идентификатор вакансии.
     * @param files файлы вакансии.
     */
    @Multipart
    @POST("vacancy/{id}/upload-files")
    suspend fun uploadVacancyFiles(
        @Path("id") id: String,
        @Part files: List<MultipartBody.Part>,
    )

    /**
     * Краткий список вакансий
     */
    @GET("vacancy/short")
    suspend fun getVacanciesShort()
}