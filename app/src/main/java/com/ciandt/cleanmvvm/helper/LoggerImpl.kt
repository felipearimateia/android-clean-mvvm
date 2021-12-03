package com.ciandt.cleanmvvm.helper

import timber.log.Timber

class LoggerImpl: Logger {
    override fun e(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.e(t, message, args)
    }

    override fun i(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.i(t, message, args)
    }

    override fun d(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.d(t, message, args)
    }

    override fun w(t: Throwable?, message: String?, vararg args: Any?) {
        Timber.w(t, message, args)
    }
}