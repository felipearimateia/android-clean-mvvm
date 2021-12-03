package com.ciandt.cleanmvvm.data.repositories

import com.ciandt.cleanmvvm.data.api.LoginApi
import com.ciandt.cleanmvvm.data.model.LoginRequest
import com.ciandt.cleanmvvm.data.model.toLogin
import com.ciandt.cleanmvvm.domain.model.Login
import com.ciandt.cleanmvvm.helper.Result
import com.ciandt.cleanmvvm.helper.handleHttpError

class LoginRepositoryImpl(private val loginApi: LoginApi) : LoginRepository {

    override suspend fun login(email: String, password: String): Result<Login> {
        try {
            val request = LoginRequest(email, password)
            val response = loginApi.login(request)

            if (response.isSuccessful) {
                return Result.Success(response.body()!!.toLogin())
            }

            return Result.Failure(handleHttpError(response.code()))
        } catch (e: Exception) {
            return Result.Failure(e)
        }
    }
}