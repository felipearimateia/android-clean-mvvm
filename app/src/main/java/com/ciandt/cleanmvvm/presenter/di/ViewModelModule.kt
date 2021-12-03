package com.ciandt.cleanmvvm.presenter.di

import com.ciandt.cleanmvvm.presenter.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { LoginViewModel(get()) }
}