package com.jpndev.mvvmdemo.data.repository.tvshow.datasource

import com.jpndev.mvvmdemo.data.model.TvShow

interface TvCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowToCache(movie:List<TvShow>)
   // suspend fun clearAll()
}