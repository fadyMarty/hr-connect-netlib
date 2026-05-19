package com.hrconnect.netlib.data.manager

class TokenManager {

    private var token: String? = null

    fun saveToken(token: String) {
        this.token = token
    }

    fun getToken(): String? {
        return token
    }
}