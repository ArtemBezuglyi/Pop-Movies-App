package ru.artbez.moviepop.screens.pop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.databinding.FragmentPopBinding
import ru.artbez.moviepop.models.MovieItemModel

class PopFragment : Fragment() {

    private var pFrBinding: FragmentPopBinding?= null
    private val binding get() = pFrBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { PopAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pFrBinding = FragmentPopBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(PopFragmentViewModel::class.java)
        recyclerView = binding.rvPop
        recyclerView.adapter = adapter

viewModel.getAllMyMovies().observe(viewLifecycleOwner, {list ->
    adapter.setList(list.asReversed())
})


    }

    override fun onDestroyView() {
        super.onDestroyView()
        pFrBinding = null
    }

    companion object {
        fun clickMovie(model: MovieItemModel) {
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            MAIN.navController.navigate(R.id.action_popFragment_to_detailFragment, bundle)
        }
    }

}