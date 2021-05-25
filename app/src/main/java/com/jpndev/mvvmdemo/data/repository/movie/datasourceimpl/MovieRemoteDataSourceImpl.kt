package com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl

import com.jpndev.mvvmdemo.data.model.MoviesList
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.retrofitdemo.network.ApiService
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val apiService: ApiService,private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MoviesList>
    =apiService.getPopularMovies(apiKey)

}