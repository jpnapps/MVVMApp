package com.jpndev.mvvmdemo.data.repository.star.datasource

import com.jpndev.mvvmdemo.data.model.Star

interface StarCacheDataSource {
    suspend fun getStarsFromCache():List<Star>
    suspend fun saveStarToCache(movie:List<Star>)
   // suspend fun clearAll()
}