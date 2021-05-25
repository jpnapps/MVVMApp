package com.jpndev.mvvmdemo.data.repository.star.datasource

import com.jpndev.mvvmdemo.data.model.Star

interface StarLocalDataSource {
    suspend fun getStarsFromDB():List<Star>
    suspend fun saveStarsToDB(movie:List<Star>)
    suspend fun clearAll()
}