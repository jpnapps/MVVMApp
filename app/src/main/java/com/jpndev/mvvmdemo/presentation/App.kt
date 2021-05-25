package com.jpndev.mvvmdemo.presentation

import android.app.Application
import com.jpndev.mvvmdemo.BuildConfig
import com.jpndev.mvvmdemo.presentation.di.Injector
import com.jpndev.mvvmdemo.presentation.di.core.*
import com.jpndev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.jpndev.mvvmdemo.presentation.di.star.StarSubComponent
import com.jpndev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent


class App :Application(),Injector {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createStarSubComponent(): StarSubComponent {
        return appComponent.starSubComponent().create()
    }
}