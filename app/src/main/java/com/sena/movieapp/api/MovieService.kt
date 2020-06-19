package com.sena.movieapp.api

import com.sena.movieapp.data.ResultWrapper
import com.sena.movieapp.data.model.MovieResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("4/discover/movie?sort_by=popularity.desc")
    suspend fun getTopMovies(): ResultWrapper<MovieResponseModel>

    @GET("3/movie/{movieId}")
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): MovieResponseModel

    companion object {
        const val POPULAR = "movie/popular"
        const val GENRE = "genre/movie/list"
        const val NOW_PLAYING = "movie/now_playing"
        const val PATH_MOVIE_ID = "movie_id"
        const val DETAIL = "movie/{$PATH_MOVIE_ID}"
        const val CREDIT = "movie/{$PATH_MOVIE_ID}/credits"
    }
}

