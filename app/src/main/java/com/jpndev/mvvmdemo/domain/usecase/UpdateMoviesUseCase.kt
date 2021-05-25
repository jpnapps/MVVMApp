package com.jpndev.mvvmdemo.domain.usecase

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>?=movieRepository.updatedMovies()
}