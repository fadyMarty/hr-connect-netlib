package com.hrconnect.netlib.data.remote

import retrofit2.http.GET

/**
 * API-интерфейс для работы с данными найма персонала.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface HiringApi {

    /**
     * Подразделения.
     */
    @GET("hiring/departments")
    suspend fun getDepartments()

    /**
     * Должности.
     */
    @GET("hiring/positions")
    suspend fun getPositions()

    /**
     * Список вакансий для HR доски.
     */
    @GET("hiring/vacancies")
    suspend fun getHiringVacancies()
}