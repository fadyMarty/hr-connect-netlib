package com.hrconnect.netlib.data.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * API-интерфейс для работы с соискателями и сотрудниками.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface EmployeeApi {

    /**
     * Список соискателей.
     */
    @POST("employee/applicantListBy")
    suspend fun getApplicants()

    /**
     * Сотрудник по ID.
     *
     * @param id идентификатор сотрудника.
     */
    @GET("employee/{id}")
    suspend fun getEmployeeById(
        @Path("id") id: String,
    )

    /**
     * Краткий список HR-специалистов.
     */
    @GET("employee/shortStaff")
    suspend fun getShortStaff()
}