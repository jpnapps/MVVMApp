package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.star.datasourceimpl.StarRemoteDataSourceImpl
import com.jpndev.mvvmdemo.data.repository.tvshow.datasource.TvRemoteDataSource
import com.jpndev.mvvmdemo.data.repository.tvshow.datasourceimpl.TvRemoteDataSourceImpl
import com.jpndev.mvvmdemo.domain.repository.MovieRepository
import com.jpndev.mvvmdemo.domain.repository.StarRepository
import com.jpndev.mvvmdemo.domain.repository.TvShowRepository
import com.jpndev.mvvmdemo.domain.usecase.*
import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {


    @Singleton
    @Provides
    fun providesGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return  GetMoviesUseCase(movieRepository)
    }


    @Singleton
    @Provides
    fun providesUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return  UpdateMoviesUseCase(movieRepository)
    }




    @Singleton
    @Provides
    fun providesGetTvShowUseCase(repository: TvShowRepository): GetTvshowsUseCase {
        return  GetTvshowsUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesUpdateTvShowsUseCase(repository: TvShowRepository): UpdateTvShowsUseCase {
        return  UpdateTvShowsUseCase(repository)
    }



    @Singleton
    @Provides
    fun providesGetStarsUseCase(repository: StarRepository): GetStarsUseCase {
        return  GetStarsUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesUpdateStarsUseCase(repository: StarRepository): UpdateStarsUseCase {
        return  UpdateStarsUseCase(repository)
    }
}