package com.hrconnect.netlib.employee.domain.repository

interface EmployeeRepository {
    suspend fun getApplicants(): Result<Unit>
    suspend fun getEmployeeById(id: String): Result<Unit>
    suspend fun getShortStaff(): Result<Unit>
}