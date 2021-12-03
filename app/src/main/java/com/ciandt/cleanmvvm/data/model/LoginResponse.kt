package com.ciandt.cleanmvvm.data.model

import com.ciandt.cleanmvvm.domain.model.Login
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val name: String,
    val avatar: String,
    val uuid: String,
    val id: String
    )

fun LoginResponse.toLogin() = Login(
    name = name,
    avatar = avatar,
    uuid = uuid,
    id = id
)
