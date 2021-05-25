package com.jpndev.mvvmdemo.presentation.di.movie

import com.jpndev.mvvmdemo.presentation.movie.MovieActivity
import com.jpndev.mvvmdemo.presentation.star.StarActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@MovieScope
@Subcomponent(modules = [
    MovieModule::class]

    )
interface MovieSubComponent {

    fun inject(activity:MovieActivity)

    @Subcomponent.Factory
    interface Factory{
       fun create():MovieSubComponent
    }
}

