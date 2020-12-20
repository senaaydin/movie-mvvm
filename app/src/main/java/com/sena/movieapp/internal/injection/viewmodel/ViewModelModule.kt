package com.sena.movieapp.internal.injection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sena.movieapp.ui.MovieListViewModel
import com.sena.movieapp.ui.detail.MovieDetailViewModel
import com.sena.movieapp.ui.show.ShowDetailViewModel
import com.sena.movieapp.ui.show.ShowListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    internal abstract fun bindMovieListViewModel(viewModel: MovieListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowListViewModel::class)
    internal abstract fun bindShowListViewModel(viewModel: ShowListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowDetailViewModel::class)
    internal abstract fun bindShowDetailViewModel(viewModel: ShowDetailViewModel): ViewModel
}