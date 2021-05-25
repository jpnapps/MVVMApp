package com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.jpndev.mvvmdemo.data.model.StarList
import com.jpndev.mvvmdemo.data.model.TvShowsList
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.retrofitdemo.network.ApiService
import retrofit2.Response

class TvRemoteDataSourceImpl(private val apiService: ApiService, private val apiKey:String):
    TvRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowsList>
    =apiService.getPopularTvShows(apiKey)

}