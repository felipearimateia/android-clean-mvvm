package com.ciandt.cleanmvvm.presenter.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciandt.cleanmvvm.domain.EmailException
import com.ciandt.cleanmvvm.domain.login.LoginUseCase
import com.ciandt.cleanmvvm.domain.model.Login
import com.ciandt.cleanmvvm.presenter.model.LoginView
import com.ciandt.cleanmvvm.helper.Result
import com.ciandt.cleanmvvm.presenter.model.toView
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel() {

    val loginSuccess: MutableLiveData<LoginView> by lazy {
        MutableLiveData<LoginView>()
    }

    val loginFailure: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            when (val result = loginUseCase.login(email, password)) {
                is Result.Success -> handleSuccess(result.data)
                is Result.Failure -> handleFailure(result.exception)
            }
        }
    }

    private fun handleSuccess(result: Login) {
        loginSuccess.postValue(result.toView())
    }

    private fun handleFailure(exception: Exception) {
        when(exception) {
            is EmailException -> loginFailure.postValue(exception.error)
        }
    }
}