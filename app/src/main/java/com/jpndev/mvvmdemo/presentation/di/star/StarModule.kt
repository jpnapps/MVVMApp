package com.jpndev.mvvmdemo.presentation.di.star

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.repository.movie.MovieRepositoryImpl
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieCacheDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.StarRepositoryImpl
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarCacheDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarLocalDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasource.StarRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.TvShowRepositoryImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvCacheDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvLocalDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvRemoteDataSourceImpl
import com.jpndev.mvvmdemo.domain.repository.MovieRepository
import com.jpndev.mvvmdemo.domain.repository.StarRepository
import com.jpndev.mvvmdemo.domain.repository.TvShowRepository
import com.jpndev.mvvmdemo.domain.usecase.GetStarsUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateStarsUseCase
import com.jpndev.mvvmdemo.presentation.star.StarViewModelFactory
import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StarModule {


    @StarScope
    @Provides
    fun providesStarViewModelFactory(getStarsUseCase: GetStarsUseCase,
                                      updateStarsUseCase: UpdateStarsUseCase
    ): StarViewModelFactory {
        return  StarViewModelFactory(getStarsUseCase,updateStarsUseCase)
    }



}