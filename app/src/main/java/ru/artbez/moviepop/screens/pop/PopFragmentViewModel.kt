package ru.artbez.moviepop.screens.pop

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.artbez.moviepop.REALIZATION
import ru.artbez.moviepop.models.MovieItemModel

class PopFragmentViewModel: ViewModel() {

    fun getAllMyMovies(): LiveData<List<MovieItemModel>> {
        return REALIZATION.allPopMovies
    }
}