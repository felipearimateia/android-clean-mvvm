package com.ciandt.cleanmvvm.helper

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Throwable) : Result<Nothing>()
}
