package com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl

import com.jpndev.mvvmdemo.data.db.TvShowDao
import com.jpndev.mvvmdemo.data.model.TvShow
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvLocalDataSource

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImpl(private val dao: TvShowDao):
    TvLocalDataSource {


    override suspend fun getTvShowsFromDB(): List<TvShow>  =dao.getAllTvShows()
    override suspend fun saveTvShowsToDB(movie: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.saveTvShows(movie)

        }

    }



    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllTvShows()

        }
    }

}