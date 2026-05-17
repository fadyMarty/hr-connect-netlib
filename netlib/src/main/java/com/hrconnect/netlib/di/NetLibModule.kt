package com.hrconnect.netlib.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.hrconnect.netlib.auth.data.manager.TokenManagerImpl
import com.hrconnect.netlib.auth.data.remote.AuthApi
import com.hrconnect.netlib.auth.data.remote.AuthInterceptor
import com.hrconnect.netlib.auth.data.repository.AuthRepositoryImpl
import com.hrconnect.netlib.auth.domain.manager.TokenManager
import com.hrconnect.netlib.auth.domain.repository.AuthRepository
import com.hrconnect.netlib.candidate.data.remote.CandidateApi
import com.hrconnect.netlib.common.util.Constants
import com.hrconnect.netlib.dictionary.data.remote.DictionaryApi
import com.hrconnect.netlib.employee.data.remote.EmployeeApi
import com.hrconnect.netlib.hirining.data.remote.HiringApi
import com.hrconnect.netlib.vacancy.data.remote.VacancyApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

val Context.dataStore by preferencesDataStore(name = Constants.DATASTORE_FILE_NAME)

val netLibModule = module {
    singleOf(::AuthInterceptor)
    single {
        Json {
            ignoreUnknownKeys = true
        }
    }
    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(get<AuthInterceptor>())
            .build()
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

    singleOf(::TokenManagerImpl).bind<TokenManager>()
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}