package com.sena.movieapp.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.sena.movieapp.R
import com.sena.movieapp.application.MainApplication
import com.sena.movieapp.data.model.MovieResponseModel
import com.sena.movieapp.data.model.getPosterUrl
import com.sena.movieapp.util.formatDate
import com.sena.movieapp.util.loadFromUrl
import kotlinx.android.synthetic.main.movie_detail_fragment.*
import javax.inject.Inject

class MovieDetailFragment : Fragment() {
    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: MovieDetailViewModel by viewModels(factoryProducer = { factory })

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MainApplication).getAppComponent().newFragmentComponent().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setMovieId(args.movieId)
        viewModel.movie.observe(this) {
            setUpUi(it!!)
        }
    }

    private fun setUpUi(movie: MovieResponseModel) {
        detail_image.loadFromUrl(movie.getPosterUrl())
        detail_title_tv.text = movie.title
        detail_release_date_tv.text = movie.releaseDate?.formatDate() ?: "-"
        detail_average_tv.text = movie.voteAverage.toString()
        detail_overview_tv.text = movie.overview
    }

}