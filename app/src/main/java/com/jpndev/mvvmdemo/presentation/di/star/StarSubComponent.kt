package com.jpndev.mvvmdemo.presentation.di.star

import com.jpndev.mvvmdemo.presentation.star.StarActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@StarScope
@Subcomponent(modules = [
StarModule::class]

    )
interface StarSubComponent {

    fun inject(activity:StarActivity)

    @Subcomponent.Factory
    interface Factory{
       fun create():StarSubComponent
    }
}

