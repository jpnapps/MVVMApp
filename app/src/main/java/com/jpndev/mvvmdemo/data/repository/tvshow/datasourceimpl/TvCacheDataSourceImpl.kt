package com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.jpndev.mvvmdemo.data.model.TvShow

import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvCacheDataSource

class TvCacheDataSourceImpl  : TvCacheDataSource {
    private var starList=ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return  starList
    }

    override suspend fun saveTvShowToCache(movie: List<TvShow>) {
        starList.clear()
        starList=ArrayList(movie)
       // starList.addAll(movie)
    }
}