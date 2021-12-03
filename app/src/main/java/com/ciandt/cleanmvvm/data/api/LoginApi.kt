package com.ciandt.cleanmvvm.data.api

import com.ciandt.cleanmvvm.data.model.LoginRequest
import com.ciandt.cleanmvvm.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("/68c5f417-2367-42/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/68c5f417-2367-42/loginFail")
    suspend fun loginFail(@Body request: LoginRequest): Response<LoginResponse>
}