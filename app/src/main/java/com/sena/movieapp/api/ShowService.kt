package com.sena.movieapp.api

import com.sena.movieapp.data.ResultWrapper
import com.sena.movieapp.data.model.ShowResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ShowService {

    @GET("4/discover/tv?sort_by=popularity.desc")
    suspend fun getTopShows(): ResultWrapper<ShowResponseModel>

    @GET("3/tv/{tv_id}")
    suspend fun getShowDetails(@Path("tv_id") movieId: Int): ShowResponseModel

}