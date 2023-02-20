package ru.artbez.moviepop.screens.en4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import ru.artbez.moviepop.REALIZATION
import ru.artbez.moviepop.data.retrofit.RetrofitRepository
import ru.artbez.moviepop.data.room.MoviesRoomDatabase
import ru.artbez.moviepop.data.room.repository.MoviesRepositoryRealization
import ru.artbez.moviepop.models.MovieModel

class En4ViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MovieModel>> = MutableLiveData()
    val context = application

    fun getEn4Movies(){
        viewModelScope.launch {
            myMovies.value = repository.getEn4Movies()
        }
    }

    fun initDatabase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALIZATION = MoviesRepositoryRealization(daoMovie)
    }

}