package com.jpndev.mvvmdemo.data.repository.movie.datasource

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.model.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MoviesList>
    //suspend fun updatedMovies():List<Movie>
}