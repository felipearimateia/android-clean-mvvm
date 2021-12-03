package com.ciandt.cleanmvvm.domain.login

import com.ciandt.cleanmvvm.domain.model.Login
import com.ciandt.cleanmvvm.helper.Result

interface LoginUseCase {

    suspend fun login(email: String, password: String): Result<Login>
}