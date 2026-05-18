package com.hrconnect.netlib.hirining.data.repository

import com.hrconnect.netlib.common.util.safeCall
import com.hrconnect.netlib.hirining.data.remote.HiringApi
import com.hrconnect.netlib.hirining.domain.repository.HiringRepository

class HiringRepositoryImpl(
    private val hiringApi: HiringApi,
) : HiringRepository {

    override suspend fun getDepartments(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Подразделения"
        ) {
            hiringApi.getDepartments()
        }
    }

    override suspend fun getPositions(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Должности"
        ) {
            hiringApi.getPositions()
        }
    }

    override suspend fun getHiringVacancies(): Result<Unit> {
        return safeCall(
            tag = TAG,
            message = "Список вакансий для HR доски"
        ) {
            hiringApi.getHiringVacancies()
        }
    }

    companion object {
        private const val TAG = "HiringRepositoryImpl"
    }
}