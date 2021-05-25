package com.jpndev.mvvmdemo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jpndev.mvvmdemo.data.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: Movie)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)


    @Update
    suspend fun updateMovie(movie: Movie)



    @Delete
    suspend fun deleteMovie(movie: Movie)


    @Query("DELETE  FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
     fun getAllMovies():List<Movie>
}