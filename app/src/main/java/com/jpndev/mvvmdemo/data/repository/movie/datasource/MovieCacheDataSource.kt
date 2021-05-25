package com.jpndev.mvvmdemo.data.repository.movie.datasource

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.model.MoviesList
import retrofit2.Response

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMovieToCache(movie:List<Movie>)
   // suspend fun clearAll()
}