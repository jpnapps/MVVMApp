package com.jpndev.mvvmdemo.data.repository.star.datasourceimpl

import com.jpndev.mvvmdemo.data.model.StarList
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarRemoteDataSource
import com.jpndev.retrofitdemo.network.ApiService
import retrofit2.Response

class StarRemoteDataSourceImpl(private val apiService: ApiService, private val apiKey:String):
    StarRemoteDataSource {
    override suspend fun getStars(): Response<StarList>
    =apiService.getPopularStarss(apiKey)

}