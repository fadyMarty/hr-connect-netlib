package com.hrconnect.netlib.vacancy.data.remote

import okhttp3.MultipartBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface VacancyApi {

    @GET("vacancy")
    suspend fun getVacancies()

    @POST("vacancy")
    suspend fun createVacancy()

    @POST("vacancy/{id}")
    suspend fun getVacancyById(
        @Path("id") id: String,
    )

    @PUT("vacancy/{id}")
    suspend fun updateVacancy(
        @Path("id") id: String,
    )

    @DELETE("vacancy/{id}")
    suspend fun deleteVacancy(
        @Path("id") id: String,
    )

    @Multipart
    @POST("vacancy/{id}/upload-files")
    suspend fun uploadVacancyFiles(
        @Path("id") id: String,
        @Part files: List<MultipartBody.Part>,
    )

    @GET("vacancy/short")
    suspend fun getVacanciesShort()
}