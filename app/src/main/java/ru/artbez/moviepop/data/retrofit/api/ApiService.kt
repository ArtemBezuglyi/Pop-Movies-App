package ru.artbez.moviepop.data.retrofit.api

import retrofit2.Response
import retrofit2.http.GET
import ru.artbez.moviepop.models.MovieModel

interface ApiService {

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=ru-RU&page=1")
    suspend fun getPopMovies(): Response<MovieModel>

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=en-US&page=1")
    suspend fun getPopEn1Movies(): Response<MovieModel>

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=en-US&page=2")
    suspend fun getPopEn2Movies(): Response<MovieModel>

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=en-US&page=3")
    suspend fun getPopEn3Movies(): Response<MovieModel>

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=en-US&page=4")
    suspend fun getPopEn4Movies(): Response<MovieModel>

    @GET("3/movie/popular?api_key=4f25a817a902ffb0c564252c8a900ff8&language=en-US&page=5")
    suspend fun getPopEn5Movies(): Response<MovieModel>
}