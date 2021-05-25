package com.jpndev.mvvmdemo.data.repository.star.datasource

import com.jpndev.mvvmdemo.data.model.StarList
import retrofit2.Response

interface StarRemoteDataSource {
    suspend fun getStars():Response<StarList>
    //suspend fun updatedMovies():List<Movie>
}