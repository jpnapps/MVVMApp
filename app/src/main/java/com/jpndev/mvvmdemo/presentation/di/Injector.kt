package com.jpndev.mvvmdemo.presentation.di

import com.jpndev.mvvmdemo.presentation.di.movie.MovieSubComponent
import com.jpndev.mvvmdemo.presentation.di.star.StarSubComponent
import com.jpndev.mvvmdemo.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createStarSubComponent():StarSubComponent
}