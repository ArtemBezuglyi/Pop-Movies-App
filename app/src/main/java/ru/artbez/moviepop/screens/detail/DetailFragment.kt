package ru.artbez.moviepop.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.SharedPref
import ru.artbez.moviepop.databinding.FragmentDetailBinding
import ru.artbez.moviepop.models.MovieItemModel


class DetailFragment : Fragment() {


    private var dFrBinding: FragmentDetailBinding ?= null
    private val binding get() = dFrBinding!!
lateinit var currentMovie: MovieItemModel
private var isPop = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dFrBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBoolean = SharedPref.getPop(MAIN, currentMovie.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        if (isPop != valueBoolean) {
            binding.imgDetailPop.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.imgDetailPop.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }


Glide.with(MAIN)
    .load("https:/www.themoviedb.org/t/p/w600_and_h900_bestv2${currentMovie.poster_path}")
    //.centerCrop()
    .placeholder(R.drawable.ic_launcher_foreground)
    .into(binding.imgDetail)
        binding.tvTitle.text = currentMovie.title
        binding.tvDate.text = currentMovie.release_date
        binding.tvOverview.text = "   " + "${currentMovie.overview}"

        binding.imgDetailPop.setOnClickListener {
            if (isPop == valueBoolean) {
                binding.imgDetailPop.setImageResource(R.drawable.ic_baseline_favorite_24)
                SharedPref.setPop(MAIN, currentMovie.id.toString(), true)
                viewModel.insert(currentMovie){}
                isPop = true
            } else {
                binding.imgDetailPop.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                SharedPref.setPop(MAIN, currentMovie.id.toString(), false)
                viewModel.delete(currentMovie){}
                isPop = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dFrBinding = null
    }

}

