package com.hrconnect.netlib.hirining.data.remote

import retrofit2.http.GET

interface HiringApi {

    @GET("hiring/departments")
    suspend fun getDepartments()

    @GET("hiring/positions")
    suspend fun getPositions()

    @GET("hiring/vacancies")
    suspend fun getHiringVacancies()
}