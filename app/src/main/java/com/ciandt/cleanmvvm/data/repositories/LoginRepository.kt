package com.ciandt.cleanmvvm.data.repositories

import com.ciandt.cleanmvvm.domain.model.Login
import com.ciandt.cleanmvvm.helper.Result

interface LoginRepository {
    suspend fun login(email: String, password: String): Result<Login>
}