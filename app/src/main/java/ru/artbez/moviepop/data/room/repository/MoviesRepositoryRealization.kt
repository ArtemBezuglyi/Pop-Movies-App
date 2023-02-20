package ru.artbez.moviepop.data.room.repository

import androidx.lifecycle.LiveData
import ru.artbez.moviepop.data.room.dao.MoviesDao
import ru.artbez.moviepop.models.MovieItemModel

class MoviesRepositoryRealization(private val moviesDao: MoviesDao): MoviesRepository {
    override val allPopMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllPopMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }
}