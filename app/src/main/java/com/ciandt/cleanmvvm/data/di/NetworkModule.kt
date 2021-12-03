package com.ciandt.cleanmvvm.data.di

import com.ciandt.cleanmvvm.data.api.LoginApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule: Module = module {

    single {
        val loggingInterceptor: HttpLoggingInterceptor = get()
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://www.mockachino.com")
            .addConverterFactory(get())
            .client(get())
            .build()
    }
    
    single {
        Json {
            ignoreUnknownKeys = true
            encodeDefaults = false
        }.asConverterFactory(get())
    }

    single { "application/json".toMediaType() }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<LoginApi> {
        val retrofit: Retrofit = get()
        retrofit.create(LoginApi::class.java)
    }
}