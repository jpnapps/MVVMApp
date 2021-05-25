package com.jpndev.mvvmdemo.data.repository.star.datasourceimpl

import com.jpndev.mvvmdemo.data.db.StarDao
import com.jpndev.mvvmdemo.data.model.Star
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StarLocalDataSourceImpl(private val dao: StarDao):
    StarLocalDataSource {


    override suspend fun getStarsFromDB(): List<Star>  =dao.getAllStars()
    override suspend fun saveStarsToDB(movie: List<Star>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveStars(movie)

        }

    }



    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllStars()

        }
    }

}