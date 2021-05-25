package com.jpndev.mvvmdemo.data.repository.star

import android.util.Log
import com.jpndev.mvvmdemo.data.model.Star
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarCacheDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarLocalDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarRemoteDataSource

import com.jpndev.mvvmdemo.domain.repository.StarRepository
import java.lang.Exception

class StarRepositoryImpl(private val starRemoteDataSource: StarRemoteDataSource,
                         private val starLocalDataSource: StarLocalDataSource,
                         private val starCacheDataSource: StarCacheDataSource

                          ) :StarRepository {
    override suspend fun getStars(): List<Star> {
        return getStarsFromCache()

    }

    override suspend fun updatedStars(): List<Star> {
        var newstarlist:List<Star> =getStarsFromApi()
        starLocalDataSource.clearAll()
        starLocalDataSource.saveStarsToDB(newstarlist)
        starCacheDataSource.saveStarToCache(newstarlist)

        return newstarlist

    }


    suspend fun getStarsFromApi():List<Star> {
var starlist:List<Star> =ArrayList<Star>()
     try{

        val response= starRemoteDataSource.getStars()
         val body= response.body()
       if(body!=null)
       {
           starlist=body.stars
       }

     }catch (e:Exception)
     {

         Log.i("MYTAG","getStarsFromApi e "+e.message.toString())
     }
        return starlist
    }


    suspend fun getStarsFromDB():List<Star> {
        var starlist:List<Star> =ArrayList<Star>()
        try{

            starlist= starLocalDataSource.getStarsFromDB()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getStarsFromDB e "+e.message.toString())
        }

        if(starlist.size>0)
        {
            return starlist
        }
        else{
            starlist=getStarsFromApi()
            starLocalDataSource.saveStarsToDB(starlist)
        }
        return starlist
    }

    suspend fun getStarsFromCache():List<Star> {
        var starlist:List<Star> =ArrayList<Star>()
        try{

            starlist= starCacheDataSource.getStarsFromCache()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getStarsFromDB e "+e.message.toString())
        }

        if(starlist.size>0)
        {
            return starlist
        }
        else{
            starlist=getStarsFromDB()
            starCacheDataSource.saveStarToCache(starlist)
        }
        return starlist
    }
}