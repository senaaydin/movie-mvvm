package com.sena.movieapp.ui.show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sena.movieapp.data.ShowRepository
import javax.inject.Inject

class ShowListViewModel @Inject constructor(private val repository: ShowRepository) :
    ViewModel() {
    val topShows = liveData {
        emit(repository.fetchTopShows())
    }
}