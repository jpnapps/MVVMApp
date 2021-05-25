package com.jpndev.mvvmdemo.presentation.di.movie

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.repository.movie.MovieRepositoryImpl
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl

import com.jpndev.mvvmdemo.data.repository.tvshow.TvShowRepositoryImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvCacheDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvLocalDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvRemoteDataSourceImpl
import com.jpndev.mvvmdemo.domain.repository.MovieRepository

import com.jpndev.mvvmdemo.domain.repository.TvShowRepository
import com.jpndev.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateMoviesUseCase
import com.jpndev.mvvmdemo.presentation.movie.MovieViewModelFactory

import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {


    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                      updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return  MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }



}