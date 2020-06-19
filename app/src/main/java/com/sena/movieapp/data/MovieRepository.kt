package com.sena.movieapp.data

import com.sena.movieapp.api.MovieService
import com.sena.movieapp.data.model.MovieResponseModel
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun fetchTopMovies() = movieService.getTopMovies().results

    suspend fun fetchMovieDetails(id: Int) = movieService.getMovieDetails(id)

}