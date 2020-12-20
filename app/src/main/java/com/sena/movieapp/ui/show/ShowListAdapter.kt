package com.sena.movieapp.ui.show

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sena.movieapp.R
import com.sena.movieapp.data.model.ShowResponseModel
import com.sena.movieapp.data.model.getPosterUrl
import com.sena.movieapp.util.formatDate
import com.sena.movieapp.util.loadFromUrl
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class ShowListAdapter : ListAdapter<ShowResponseModel, ShowListAdapter.ViewHolder>(
    DiffUtilCallback()
) {
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = getItem(position)
        holder.bind(show)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(show: ShowResponseModel) {
            itemView.image_view_poster.loadFromUrl(show.getPosterUrl())
            itemView.text_view_title.text = show.originalName
            itemView.text_view_release_date.text = show.firstAirDate?.formatDate() ?: "-"
            itemView.text_view_average.text = "Rating: ${show.voteAverage.toString()}"
            itemView.setOnClickListener { listener.onItemClicked(show) }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(show: ShowResponseModel)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<ShowResponseModel>() {

        override fun areItemsTheSame(oldItem: ShowResponseModel, newItem: ShowResponseModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShowResponseModel, newItem: ShowResponseModel): Boolean {
            return oldItem.equals(newItem)
        }
    }


}