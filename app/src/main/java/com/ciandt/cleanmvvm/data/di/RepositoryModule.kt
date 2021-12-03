package com.ciandt.cleanmvvm.data.di

import com.ciandt.cleanmvvm.data.repositories.LoginRepository
import com.ciandt.cleanmvvm.data.repositories.LoginRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module


val repositoryModule: Module = module {
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}
