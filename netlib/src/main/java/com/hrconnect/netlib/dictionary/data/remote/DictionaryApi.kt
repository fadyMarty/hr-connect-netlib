package com.hrconnect.netlib.dictionary.data.remote

import retrofit2.http.GET

interface DictionaryApi {

    @GET("dictionary/city")
    suspend fun getCities()

    @GET("dictionary/status")
    suspend fun getStatuses()

    @GET("dictionary/candidateStatuses")
    suspend fun getCandidateStatuses()
}