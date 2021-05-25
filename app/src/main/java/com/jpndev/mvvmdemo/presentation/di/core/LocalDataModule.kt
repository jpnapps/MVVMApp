package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.db.MovieDao
import com.jpndev.mvvmdemo.data.db.StarDao
import com.jpndev.mvvmdemo.data.db.TvShowDao
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarLocalDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarLocalDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvLocalDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvLocalDataSourceImpl
import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {


    @Singleton
    @Provides
    fun providesMovieLocalDataSource(dao: MovieDao): MovieLocalDataSource {
        return  MovieLocalDataSourceImpl(dao)
    }


    @Singleton
    @Provides
    fun providesTvLocalDataSource(dao: TvShowDao): TvLocalDataSource {
        return  TvLocalDataSourceImpl(dao)
    }



    @Singleton
    @Provides
    fun providesStarLocalDataSource(dao: StarDao): StarLocalDataSource {
        return  StarLocalDataSourceImpl(dao)
    }
}