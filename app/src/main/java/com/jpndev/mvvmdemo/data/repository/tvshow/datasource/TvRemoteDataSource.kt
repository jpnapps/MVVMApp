package com.jpndev.mvvmdemo.data.repository.tvshow.datasource

import com.jpndev.mvvmdemo.data.model.StarList
import com.jpndev.mvvmdemo.data.model.TvShowsList
import retrofit2.Response

interface TvRemoteDataSource {
    suspend fun getTvShows():Response<TvShowsList>
    //suspend fun updatedMovies():List<Movie>
}