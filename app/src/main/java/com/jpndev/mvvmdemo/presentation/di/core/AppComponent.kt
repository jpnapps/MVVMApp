package com.jpndev.mvvmdemo.presentation.di.core

import com.jpndev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.jpndev.mvvmdemo.presentation.di.star.StarSubComponent
import com.jpndev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
NetworkModule::class,
DatabaseModule::class,
RepositoryModule::class,
CacheDataModule::class,
LocalDataModule::class,
RemoteDataModule::class,
UseCaseModule::class]

    )  
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun starSubComponent():StarSubComponent.Factory
}