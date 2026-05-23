package com.hrconnect.netlib.data.remote

import retrofit2.http.GET

/**
 * API-интерфейс для работы со справочными данными.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface DictionaryApi {

    /**
     * Города.
     */
    @GET("dictionary/city")
    suspend fun getCities()

    /**
     * Статусы соискателей.
     */
    @GET("dictionary/status")
    suspend fun getStatuses()

    /**
     * Статусы HR доски.
     */
    @GET("dictionary/candidateStatuses")
    suspend fun getCandidateStatuses()
}