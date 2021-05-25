package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import com.jpndev.mvvmdemo.data.db.MovieDao
import com.jpndev.mvvmdemo.data.repository.movie.datasource.MovieLocalDataSource
import com.jpndev.mvvmdemo.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.jpndev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.jpndev.mvvmdemo.presentation.di.star.StarSubComponent
import com.jpndev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton


@Module(subcomponents=[MovieSubComponent::class, TvShowSubComponent::class, StarSubComponent::class])
class AppModule (private val  context:Context){

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }

}