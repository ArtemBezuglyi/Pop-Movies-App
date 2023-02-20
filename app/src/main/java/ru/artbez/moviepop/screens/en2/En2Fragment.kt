package ru.artbez.moviepop.screens.en2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.En2Binding
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.screens.en2.En2Adapter
import ru.artbez.moviepop.screens.en2.En2ViewModel

class En2Fragment : Fragment() {

    private var en2Binding: En2Binding?= null
    private val binding get() = en2Binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { En2Adapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        en2Binding = En2Binding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(En2ViewModel::class.java)

        viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getEn2Movies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
            adapter.setList(list.body()!!.results)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        en2Binding = null
    }

    companion object {
        fun click2Movie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_en2Fragment_to_detailFragment, bundle)
        }
    }
}