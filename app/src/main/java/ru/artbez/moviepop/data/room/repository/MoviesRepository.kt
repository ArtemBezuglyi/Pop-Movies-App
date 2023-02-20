package ru.artbez.moviepop.data.room.repository

import androidx.lifecycle.LiveData
import ru.artbez.moviepop.models.MovieItemModel

interface MoviesRepository {

    val allPopMovies: LiveData<List<MovieItemModel>>
    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)
    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)
}