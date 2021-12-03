package com.ciandt.cleanmvvm.domain.login

import android.util.Patterns
import com.ciandt.cleanmvvm.data.repositories.LoginRepository
import com.ciandt.cleanmvvm.domain.EmailException
import com.ciandt.cleanmvvm.domain.model.Login
import com.ciandt.cleanmvvm.helper.Result

class LoginUseCaseImpl(
    private val loginRepository: LoginRepository
    ): LoginUseCase {

    override suspend fun login(email: String, password: String): Result<Login> {
        return if (validateEmail(email)) {
            loginRepository.login(email, password)
        } else {
            Result.Failure(EmailException())
        }
    }

    private fun validateEmail(email: String): Boolean =  Patterns.EMAIL_ADDRESS.matcher(email).matches()
}