package com.sena.movieapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sena.movieapp.R
import com.sena.movieapp.data.model.MovieResponseModel
import com.sena.movieapp.data.model.getPosterUrl
import com.sena.movieapp.util.formatDate
import com.sena.movieapp.util.loadFromUrl
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter : ListAdapter<MovieResponseModel, MovieListAdapter.ViewHolder>(
    DiffUtilCallback()
) {
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: MovieResponseModel) {
            itemView.image.loadFromUrl(movie.getPosterUrl())
            itemView.title_tv.text = movie.title
            itemView.release_date_tv.text = movie.releaseDate?.formatDate() ?: "-"
            itemView.vote_average_tv.text = "Rating: ${movie.voteAverage.toString()}"
            itemView.setOnClickListener { listener.onItemClicked(movie) }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(movie: MovieResponseModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<MovieResponseModel>() {

        override fun areItemsTheSame(oldItem: MovieResponseModel, newItem: MovieResponseModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieResponseModel, newItem: MovieResponseModel): Boolean {
            return oldItem.equals(newItem)
        }
    }


}