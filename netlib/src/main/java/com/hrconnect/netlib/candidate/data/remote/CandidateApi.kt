package com.hrconnect.netlib.candidate.data.remote

import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface CandidateApi {

    @GET("candidates/vacancies")
    suspend fun getCandidateVacancies()

    @GET("candidates/card/comment/{cardId}")
    suspend fun getCardComment(
        @Path("cardId") cardId: String,
    )

    @PUT("candidates/card/comment/{cardId}")
    suspend fun updateCardComment(
        @Path("cardId") cardId: String,
    )

    @PUT("candidates/card/hr/{cardId}")
    suspend fun updateHrCard(
        @Path("cardId") cardId: String,
    )

    @PUT("candidates/status")
    suspend fun updateCandidateStatus()

    @PUT("candidates/card/{cardId}")
    suspend fun deleteCard(
        @Path("cardId") cardId: String,
    )
}