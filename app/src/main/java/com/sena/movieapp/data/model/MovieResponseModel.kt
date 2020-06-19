package com.sena.movieapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponseModel(
    val id: Int,
    val title: String,
    val overview: String,
    val adult: Boolean?,
    val budget: Int?,
    val homepage: String?,
    val status: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
) : Parcelable

fun MovieResponseModel.getPosterUrl() = "https://image.tmdb.org/t/p/w500/${this.posterPath}"