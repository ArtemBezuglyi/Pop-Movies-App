package ru.artbez.moviepop.screens.en3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.En3Binding
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.screens.en3.En3Adapter
import ru.artbez.moviepop.screens.en3.En3ViewModel

class En3Fragment : Fragment() {

    private var en3Binding: En3Binding?= null
    private val binding get() = en3Binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { En3Adapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        en3Binding = En3Binding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(En3ViewModel::class.java)

        viewModel.initDatabase()

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.getEn3Movies()
        viewModel.myMovies.observe(viewLifecycleOwner, {list ->
            adapter.setList(list.body()!!.results)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        en3Binding = null
    }

    companion object {
        fun click3Movie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_en3Fragment_to_detailFragment, bundle)
        }
    }
}