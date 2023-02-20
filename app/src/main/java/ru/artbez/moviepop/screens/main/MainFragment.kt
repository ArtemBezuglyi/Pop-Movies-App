package ru.artbez.moviepop.screens.main

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.FragmentMainBinding
import ru.artbez.moviepop.models.MovieItemModel


class MainFragment : Fragment() {

    private var mFrBinding: FragmentMainBinding ?= null
    private val binding get() = mFrBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mFrBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
    adapter.setList(list.body()!!.results)
})

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mFrBinding = null
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_pop -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_popFragment)
            true
        }
            R.id.item_pop_en1 -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_en1Fragment)
                true
            }
            R.id.item_pop_en2 -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_en2Fragment)
                true
            }
            R.id.item_pop_en3 -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_en3Fragment)
                true
            }
            R.id.item_pop_en4 -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_en4Fragment)
                true
            }
            R.id.item_pop_en5 -> {
                MAIN.navController.navigate(R.id.action_mainFragment_to_en5Fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun clickMovie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }
}