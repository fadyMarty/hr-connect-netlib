package com.hrconnect.netlib.hirining.domain.repository

interface HiringRepository {
    suspend fun getDepartments(): Result<Unit>
    suspend fun getPositions(): Result<Unit>
    suspend fun getHiringVacancies(): Result<Unit>
}