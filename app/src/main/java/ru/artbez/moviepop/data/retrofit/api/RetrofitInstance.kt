package ru.artbez.moviepop.data.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.artbez.moviepop.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy { 
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     val api: ApiService by lazy {
         retrofit.create(ApiService::class.java)
     }

}