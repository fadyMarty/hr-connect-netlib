package com.hrconnect.netlib.auth.data.manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.hrconnect.netlib.auth.domain.manager.TokenManager
import com.hrconnect.netlib.di.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManagerImpl(
    private val context: Context,
) : TokenManager {

    private val tokenKey = stringPreferencesKey("token")

    override fun getToken(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[tokenKey]
        }
    }

    override suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[tokenKey] = token
        }
    }

    override suspend fun deleteToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(tokenKey)
        }
    }
}