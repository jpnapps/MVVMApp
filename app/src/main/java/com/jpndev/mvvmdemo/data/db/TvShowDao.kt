package com.jpndev.mvvmdemo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jpndev.mvvmdemo.data.model.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: TvShow)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)


    @Update
    suspend fun updateTvShow(tvShow: TvShow)



    @Delete
    suspend fun deleteTvShow(tvShow: TvShow)


    @Query("DELETE  FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("select * from popular_tv_shows")
     fun getAllTvShows():List<TvShow>
}