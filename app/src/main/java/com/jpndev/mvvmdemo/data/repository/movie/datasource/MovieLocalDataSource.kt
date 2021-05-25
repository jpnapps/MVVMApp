package com.jpndev.mvvmdemo.data.repository.movie.datasource

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.model.MoviesList
import retrofit2.Response

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movie:List<Movie>)
    suspend fun clearAll()
}