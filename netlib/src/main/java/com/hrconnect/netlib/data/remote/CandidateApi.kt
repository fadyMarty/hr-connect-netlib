package com.hrconnect.netlib.data.remote

import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * API-интерфейс для работы с соискателями и карточками соискателей.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
interface CandidateApi {

    /**
     * Список соискателей HR доски.
     */
    @GET("candidates/vacancies")
    suspend fun getCandidateVacancies()

    /**
     * Комментарий карточки.
     *
     * @param cardId идентификатор карточки.
     */
    @GET("candidates/card/comment/{cardId}")
    suspend fun getCardComment(
        @Path("cardId") cardId: String,
    )

    /**
     * Обновление комментария.
     *
     * @param cardId идентификатор карточки.
     */
    @PUT("candidates/card/comment/{cardId}")
    suspend fun updateCardComment(
        @Path("cardId") cardId: String,
    )

    /**
     * Обновление HR карточки.
     */
    @PUT("candidates/card/hr/{cardId}")
    suspend fun updateHrCard(
        @Path("cardId") cardId: String,
    )

    /**
     * Обновление статуса соискателя.
     */
    @PUT("candidates/status")
    suspend fun updateCandidateStatus()

    /**
     * Удаление карточки с доски.
     *
     * @param cardId идентификатор карточки.
     */
    @PUT("candidates/card/{cardId}")
    suspend fun deleteCard(
        @Path("cardId") cardId: String,
    )
}