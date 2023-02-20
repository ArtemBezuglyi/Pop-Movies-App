package ru.artbez.moviepop.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.artbez.moviepop.REALIZATION
import ru.artbez.moviepop.data.room.repository.MoviesRepositoryRealization
import ru.artbez.moviepop.models.MovieItemModel

class DetailViewModel : ViewModel() {



    fun insert(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO) {
REALIZATION.insertMovie(movieItemModel) {
    onSuccess()
}
        }

    fun delete(movieItemModel: MovieItemModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO) {
            REALIZATION.deleteMovie(movieItemModel) {
                onSuccess()
            }
        }


}