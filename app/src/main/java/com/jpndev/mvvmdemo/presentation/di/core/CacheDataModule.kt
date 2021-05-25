package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.db.MovieDao
import com.jpndev.mvvmdemo.data.db.StarDao
import com.jpndev.mvvmdemo.data.db.TvShowDao
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarCacheDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarCacheDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvCacheDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvCacheDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvRemoteDataSourceImpl
import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMovieCacheDataSource(): MovieCacheDataSource {
        return  MovieCacheDataSourceImpl()
    }


    @Singleton
    @Provides
    fun providesTvCacheDataSource(): TvCacheDataSource {
        return  TvCacheDataSourceImpl()
    }



    @Singleton
    @Provides
    fun providesStarCacheDataSource(): StarCacheDataSource {
        return  StarCacheDataSourceImpl()
    }
}