package com.jpndev.mvvmdemo.presentation.di.tvshow

import com.jpndev.mvvmdemo.presentation.star.StarActivity
import com.jpndev.mvvmdemo.presentation.tv.TvShowsActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@TvShowScope
@Subcomponent(modules = [
TvShowModule::class]

    )
interface TvShowSubComponent {

    fun inject(activity:TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{
       fun create():TvShowSubComponent
    }
}

