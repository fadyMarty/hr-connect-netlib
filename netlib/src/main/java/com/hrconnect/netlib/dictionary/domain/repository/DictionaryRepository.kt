package com.hrconnect.netlib.dictionary.domain.repository

interface DictionaryRepository {
    suspend fun getCities(): Result<Unit>
    suspend fun getStatuses(): Result<Unit>
    suspend fun getCandidateStatuses(): Result<Unit>
}