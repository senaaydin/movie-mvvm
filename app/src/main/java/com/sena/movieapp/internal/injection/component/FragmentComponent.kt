package com.sena.movieapp.internal.injection.component

import com.sena.movieapp.internal.injection.scope.FragmentScope
import com.sena.movieapp.internal.injection.viewmodel.ViewModelModule
import com.sena.movieapp.ui.MovieListFragment
import com.sena.movieapp.ui.detail.MovieDetailFragment
import com.sena.movieapp.ui.show.ShowDetailFragment
import com.sena.movieapp.ui.show.ShowListFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface FragmentComponent {

    fun inject(fragment: MovieListFragment)

    fun inject(fragment: MovieDetailFragment)

    fun inject(fragment: ShowListFragment)

    fun inject(fragment: ShowDetailFragment)

}