package com.jpndev.mvvmdemo.domain.repository

import com.jpndev.mvvmdemo.data.model.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>
    suspend fun updatedMovies():List<Movie>
}