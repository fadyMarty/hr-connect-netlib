package com.hrconnect.netlib.employee.data.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmployeeApi {

    @POST("employee/applicantListBy")
    suspend fun getApplicants()

    @GET("employee/{id}")
    suspend fun getEmployeeById(
        @Path("id") id: String,
    )

    @GET("employee/shortStaff")
    suspend fun getShortStaff()
}