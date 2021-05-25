package com.jpndev.mvvmdemo.data.repository.movie

import android.util.Log
import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource

                          ) :MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()

    }

    override suspend fun updatedMovies(): List<Movie> {
        var newmovielist:List<Movie> =getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newmovielist)
        movieCacheDataSource.saveMovieToCache(newmovielist)

        return newmovielist

    }


    suspend fun getMoviesFromApi():List<Movie> {
        var movielist:List<Movie> = ArrayList<Movie>()
     try{

        val response= movieRemoteDataSource.getMovies()
         val body= response.body()
       if(body!=null)
       {
           movielist=body.movies
       }

     }catch (e:Exception)
     {

         Log.i("MYTAG","getMoviesFromApi e "+e.message.toString())
     }
        return movielist
    }


    suspend fun getMoviesFromDB():List<Movie> {
        var movielist:List<Movie> = ArrayList<Movie>()
        try{

            movielist= movieLocalDataSource.getMoviesFromDB()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getMoviesFromDB e "+e.message.toString())
        }

        if(movielist?.size>0)
        {
            return movielist
        }
        else{
            movielist=getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movielist)
        }
        return movielist
    }

    suspend fun getMoviesFromCache():List<Movie> {
         var movielist:List<Movie> = ArrayList<Movie>()
        try{

            movielist= movieCacheDataSource.getMoviesFromCache()



        }catch (e:Exception)
        {

            Log.i("MYTAG","getMoviesFromDB e "+e.message.toString())
        }

        if(movielist?.size>0)
        {
            return movielist
        }
        else{
            movielist=getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movielist)
        }
        return movielist
    }
}