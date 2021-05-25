package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvRemoteDataSourceImpl
import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val api_key:String){


    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(apiService: ApiService): MovieRemoteDataSource {
        return  MovieRemoteDataSourceImpl(apiService,api_key)
    }


    @Singleton
    @Provides
    fun providesTvRemoteDataSource(apiService: ApiService): TvRemoteDataSource {
        return  TvRemoteDataSourceImpl(apiService,api_key)
    }



    @Singleton
    @Provides
    fun providesStarRemoteDataSource(apiService: ApiService): StarRemoteDataSource {
        return  StarRemoteDataSourceImpl(apiService,api_key)
    }
}