package com.ciandt.cleanmvvm.di

import com.ciandt.cleanmvvm.helper.Logger
import com.ciandt.cleanmvvm.helper.LoggerImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single<Logger> { LoggerImpl() }
}