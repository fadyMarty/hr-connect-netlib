package com.hrconnect.netlib.data.manager

/**
 * Класс для работы с токеном авторизации.
 *
 * Дата создания: 23-05-2026.
 * Автор создания: 1.
 */
class TokenManager {

    private var token: String? = null

    fun saveToken(token: String) {
        this.token = token
    }

    fun getToken(): String? {
        return token
    }
}