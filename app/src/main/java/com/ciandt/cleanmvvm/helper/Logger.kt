package com.ciandt.cleanmvvm.helper

interface Logger {
    fun e(t: Throwable?, message: String?, vararg args: Any?)
    fun i(t: Throwable?, message: String?, vararg args: Any?)
    fun d(t: Throwable?, message: String?, vararg args: Any?)
    fun w(t: Throwable?, message: String?, vararg args: Any?)
}