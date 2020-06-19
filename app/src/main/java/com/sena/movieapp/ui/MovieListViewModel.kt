package com.sena.movieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sena.movieapp.data.MovieRepository
import com.sena.movieapp.internal.injection.scope.FragmentScope
import javax.inject.Inject

@FragmentScope
class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    val topMovies = liveData {
        try {
            emit(repository.fetchTopMovies())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}