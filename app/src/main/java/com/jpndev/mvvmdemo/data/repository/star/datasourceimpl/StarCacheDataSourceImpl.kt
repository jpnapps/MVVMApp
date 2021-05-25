package com.jpndev.mvvmdemo.data.repository.star.datasourceimpl

import com.jpndev.mvvmdemo.data.model.Star

import com.jpndev.mvvmdemo.data.repository.star.datasource.StarCacheDataSource

class StarCacheDataSourceImpl  : StarCacheDataSource {
    private var starList=ArrayList<Star>()
    override suspend fun getStarsFromCache(): List<Star> {
        return  starList
    }

    override suspend fun saveStarToCache(movie: List<Star>) {
        starList.clear()
        starList=ArrayList(movie)
       // starList.addAll(movie)
    }
}