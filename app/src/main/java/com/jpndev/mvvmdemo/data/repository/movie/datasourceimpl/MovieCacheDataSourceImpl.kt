package com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl

import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl  : MovieCacheDataSource {
    private var movieList=ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return  movieList
    }

    override suspend fun saveMovieToCache(movie: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(movie)
       // movieList.addAll(movie)
    }
}