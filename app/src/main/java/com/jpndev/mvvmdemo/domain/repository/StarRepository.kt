package com.jpndev.mvvmdemo.domain.repository

import com.jpndev.mvvmdemo.data.model.Star

interface StarRepository {

    suspend fun getStars():List<Star>
    suspend fun updatedStars():List<Star>
}