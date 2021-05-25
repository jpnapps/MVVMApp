package com.jpndev.mvvmdemo.domain.usecase

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>?=movieRepository.getMovies()
}