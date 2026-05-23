package com.hrconnect.netlib.di

import com.hrconnect.netlib.common.util.Constants
import com.hrconnect.netlib.data.manager.TokenManager
import com.hrconnect.netlib.data.remote.AuthApi
import com.hrconnect.netlib.data.remote.AuthInterceptor
import com.hrconnect.netlib.data.remote.CandidateApi
import com.hrconnect.netlib.data.remote.DictionaryApi
import com.hrconnect.netlib.data.remote.EmployeeApi
import com.hrconnect.netlib.data.remote.HiringApi
import com.hrconnect.netlib.data.remote.VacancyApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * DI-модуль для тестирования библиотеки NetLib
 */
val netLibModule = module {
    singleOf(::TokenManager)
    singleOf(::AuthInterceptor)
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<AuthInterceptor>())
            .build()
    }
    single {
        Json {
            ignoreUnknownKeys = true
        }
    }
    single {
        val contentType = "application/json".toMediaType()

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(get<Json>().asConverterFactory(contentType))
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(AuthApi::class.java)
    }
    single {
        get<Retrofit>().create(VacancyApi::class.java)
    }
    single {
        get<Retrofit>().create(EmployeeApi::class.java)
    }
    single {
        get<Retrofit>().create(HiringApi::class.java)
    }
    single {
        get<Retrofit>().create(DictionaryApi::class.java)
    }
    single {
        get<Retrofit>().create(CandidateApi::class.java)
    }
}