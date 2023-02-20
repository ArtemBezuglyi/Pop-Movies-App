package ru.artbez.moviepop.data.retrofit

import retrofit2.Response
import ru.artbez.moviepop.data.retrofit.api.RetrofitInstance
import ru.artbez.moviepop.models.MovieModel

class RetrofitRepository {
    suspend fun getMovies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopMovies()
    }

    suspend fun getEn1Movies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopEn1Movies()
    }

    suspend fun getEn2Movies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopEn2Movies()
    }

    suspend fun getEn3Movies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopEn3Movies()
    }

    suspend fun getEn4Movies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopEn4Movies()
    }

    suspend fun getEn5Movies(): Response<MovieModel>{
        return RetrofitInstance.api.getPopEn5Movies()
    }

}