package com.ciandt.cleanmvvm.presenter.model

import com.ciandt.cleanmvvm.domain.model.Login

data class LoginView(val name: String)

fun Login.toView() = LoginView (
    name = name
)
