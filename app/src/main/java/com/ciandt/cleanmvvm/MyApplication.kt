package com.ciandt.cleanmvvm

import android.app.Application
import com.ciandt.cleanmvvm.data.di.networkModule
import com.ciandt.cleanmvvm.data.di.repositoryModule
import com.ciandt.cleanmvvm.di.appModule
import com.ciandt.cleanmvvm.domain.di.domainModule
import com.ciandt.cleanmvvm.presenter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initLog()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, networkModule, repositoryModule, domainModule, viewModelModule)
        }
    }

    private fun initLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}