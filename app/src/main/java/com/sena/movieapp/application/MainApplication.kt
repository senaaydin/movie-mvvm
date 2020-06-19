package com.sena.movieapp.application

import android.app.Application
import com.sena.movieapp.BuildConfig
import com.sena.movieapp.internal.injection.component.AppComponent
import com.sena.movieapp.internal.injection.component.DaggerAppComponent
import com.sena.movieapp.internal.injection.module.AppModule
import com.sena.movieapp.internal.injection.module.NetworkModule
import com.sena.movieapp.util.TimberTree
import timber.log.Timber

class MainApplication : Application () {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initTimber()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    private fun initTimber() {
        if (BuildConfig.ENABLE_LOG) {
            Timber.plant(TimberTree.debug)
        } else {
            Timber.plant()
        }
    }
}