package com.ciandt.cleanmvvm.domain.di

import com.ciandt.cleanmvvm.domain.login.LoginUseCase
import com.ciandt.cleanmvvm.domain.login.LoginUseCaseImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module {
    factory<LoginUseCase> { LoginUseCaseImpl(get()) }
}