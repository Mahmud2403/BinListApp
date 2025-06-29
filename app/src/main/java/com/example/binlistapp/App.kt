package com.example.binlistapp

import android.app.Application
import com.example.binlistapp.di.databaseModule
import com.example.binlistapp.di.networkModule
import com.example.binlistapp.di.repositoryModule
import com.example.binlistapp.di.useCaseModule
import com.example.binlistapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
            )
        }
    }
}