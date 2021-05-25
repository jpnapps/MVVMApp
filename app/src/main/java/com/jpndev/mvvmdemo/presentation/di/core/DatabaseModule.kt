package com.jpndev.mvvmdemo.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.jpndev.mvvmdemo.data.db.AppDatabase
import com.jpndev.mvvmdemo.data.db.MovieDao
import com.jpndev.mvvmdemo.data.db.StarDao
import com.jpndev.mvvmdemo.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context):AppDatabase{
        return  Room.databaseBuilder(context,
            AppDatabase::class.java,"app_db").build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(database: AppDatabase):MovieDao{
        return  database.movieDao()
    }

    @Singleton
    @Provides
    fun providesTvShowDao(database: AppDatabase):TvShowDao{
        return  database.tvShowDao()
    }

    @Singleton
    @Provides
    fun providesStarDao(database: AppDatabase):StarDao{
        return  database.starDao()
    }
}