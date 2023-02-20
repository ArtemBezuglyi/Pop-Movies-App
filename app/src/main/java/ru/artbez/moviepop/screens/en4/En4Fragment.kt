package ru.artbez.moviepop.screens.en4

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.databinding.En4Binding
import ru.artbez.moviepop.screens.en4.En4Adapter
import ru.artbez.moviepop.screens.en4.En4ViewModel

class En4Fragment : Fragment() {

    private var en4Binding: En4Binding?= null
    private val binding get() = en4Binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { En4Adapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        en4Binding = En4Binding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(En4ViewModel::class.java)

        viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getEn4Movies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
            adapter.setList(list.body()!!.results)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        en4Binding = null
    }

    companion object {
        fun click4Movie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_en4Fragment_to_detailFragment, bundle)
        }
    }
}