package com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl

import com.jpndev.mvvmdemo.data.db.MovieDao
import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao):
    MovieLocalDataSource {


    override suspend fun getMoviesFromDB(): List<Movie> =movieDao.getAllMovies()

    override suspend fun saveMoviesToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movie)

        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()

        }
    }

}