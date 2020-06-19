package com.sena.movieapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sena.movieapp.R
import com.sena.movieapp.application.MainApplication
import com.sena.movieapp.data.model.MovieResponseModel
import com.sena.movieapp.util.RecyclerViewDecoration
import kotlinx.android.synthetic.main.movie_list_fragment.*
import javax.inject.Inject

class MovieListFragment : Fragment(), MovieListAdapter.OnItemClickListener{

    companion object {
        fun newInstance() = MovieListFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: MovieListViewModel by viewModels(factoryProducer = { factory })

    private val movieAdapter = MovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_list_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MainApplication).getAppComponent().newFragmentComponent().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecyclerView()

        viewModel.topMovies.observe(this) {
            movieAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        movieAdapter.setOnItemClickListener(this)
        val margin =
            (resources.getDimension(R.dimen.rv_item_margin) * resources.displayMetrics.density).toInt()
        movie_list_rv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = movieAdapter
            addItemDecoration(RecyclerViewDecoration(margin))
            setHasFixedSize(true)
        }
    }

    override fun onItemClicked(movie: MovieResponseModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}