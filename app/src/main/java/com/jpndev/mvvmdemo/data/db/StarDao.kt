package com.jpndev.mvvmdemo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jpndev.mvvmdemo.data.model.Star


@Dao
interface StarDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun saveStars(star: Star)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun saveStars(stars: List<Star>)


    @Update
    suspend fun updateStar(star: Star)



    @Delete
    suspend fun deleteStar(star: Star)


    @Query("DELETE  FROM popular_stars")
    suspend fun deleteAllStars()

    @Query("select * from popular_stars")
     fun getAllStars():List<Star>
}