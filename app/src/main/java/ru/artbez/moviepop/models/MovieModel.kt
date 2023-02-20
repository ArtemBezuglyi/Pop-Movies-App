package ru.artbez.moviepop.models

data class MovieModel(
    val page: Int,
    val results: List<MovieItemModel>,
    val total_pages: Int,
    val total_results: Int
)