package com.sena.movieapp.internal.injection.component

import com.sena.movieapp.internal.injection.module.AppModule
import com.sena.movieapp.internal.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])

interface AppComponent {

    fun newFragmentComponent(): FragmentComponent

}