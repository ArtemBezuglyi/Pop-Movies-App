package ru.artbez.moviepop.screens.en5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.En5Binding
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.screens.en5.En5Adapter
import ru.artbez.moviepop.screens.en5.En5ViewModel

class En5Fragment : Fragment() {


    private var en1Binding: En5Binding?= null
    private val binding get() = en1Binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { En5Adapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        en1Binding = En5Binding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(En5ViewModel::class.java)

        viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getEn5Movies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
            adapter.setList(list.body()!!.results)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        en1Binding = null
    }

    companion object {
        fun click5Movie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_en5Fragment_to_detailFragment, bundle)
        }
    }
}