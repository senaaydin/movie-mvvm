package com.sena.movieapp.data

import com.sena.movieapp.api.ShowService
import javax.inject.Inject

class ShowRepository @Inject constructor(
    private val showService: ShowService
) {

    suspend fun fetchTopShows() = showService.getTopShows().results

    suspend fun fetchShowDetails(id: Int) = showService.getShowDetails(id)
}