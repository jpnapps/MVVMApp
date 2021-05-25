package com.jpndev.mvvmdemo.data.repository.tvshow

import android.util.Log
import com.jpndev.mvvmdemo.data.model.TvShow

import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvCacheDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvLocalDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvRemoteDataSource,
                           private val tvShowLocalDataSource: TvLocalDataSource,
                           private val tvShowCacheDataSource: TvCacheDataSource

                          ) :TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()

    }

    override suspend fun updatedTvShows(): List<TvShow> {
        var newtvShowlist:List<TvShow> =getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newtvShowlist)
        tvShowCacheDataSource.saveTvShowToCache(newtvShowlist)

        return newtvShowlist

    }


    suspend fun getTvShowsFromApi():List<TvShow> {
      var tvShowlist:List<TvShow> = ArrayList<TvShow>()
     try{

        val response= tvShowRemoteDataSource.getTvShows()
         val body= response.body()
       if(body!=null)
       {
           tvShowlist=body.tvShows
       }

     }catch (e:Exception)
     {

         Log.i("MYTAG","getTvShowsFromApi e "+e.message.toString())
     }
        return tvShowlist
    }


    suspend fun getTvShowsFromDB():List<TvShow> {
        var tvShowlist:List<TvShow> = ArrayList<TvShow>()
        try{

            tvShowlist= tvShowLocalDataSource.getTvShowsFromDB()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getTvShowsFromDB e "+e.message.toString())
        }

        if(tvShowlist.size>0)
        {
            return tvShowlist
        }
        else{
            tvShowlist=getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowlist)
        }
        return tvShowlist
    }

    suspend fun getTvShowsFromCache():List<TvShow> {
        var tvShowlist:List<TvShow> = ArrayList<TvShow>()
        try{

            tvShowlist= tvShowCacheDataSource.getTvShowsFromCache()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getTvShowsFromDB e "+e.message.toString())
        }

        if(tvShowlist.size>0)
        {
            return tvShowlist
        }
        else{
            tvShowlist=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowlist)
        }
        return tvShowlist
    }
}