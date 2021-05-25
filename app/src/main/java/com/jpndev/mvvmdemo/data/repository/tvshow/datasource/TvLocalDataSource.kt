package com.jpndev.mvvmdemo.data.repository.tvshow.datasource

import com.jpndev.mvvmdemo.data.model.TvShow

interface TvLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(movie:List<TvShow>)
    suspend fun clearAll()
}