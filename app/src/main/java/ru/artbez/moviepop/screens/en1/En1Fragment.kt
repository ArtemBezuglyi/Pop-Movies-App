package ru.artbez.moviepop.screens.en1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.En1Binding
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.screens.en1.En1Adapter
import ru.artbez.moviepop.screens.en1.En1ViewModel

class En1Fragment : Fragment() {

    private var en1Binding: En1Binding?= null
    private val binding get() = en1Binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { En1Adapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        en1Binding = En1Binding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(En1ViewModel::class.java)

        viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getEn1Movies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
            adapter.setList(list.body()!!.results)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        en1Binding = null
    }

    companion object {
        fun click1Movie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_en1Fragment_to_detailFragment, bundle)
        }
    }
}