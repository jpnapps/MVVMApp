package com.jpndev.mvvmdemo.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jpndev.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.GetTvshowsUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(private val getTvshowsUseCase: GetTvshowsUseCase,
                      private val updateTvShowsUseCase: UpdateTvShowsUseCase
) :ViewModel (){

    fun getTvShows()= liveData {
        val list=getTvshowsUseCase.execute()
        emit(list)
    }

    fun updateTvShows()= liveData {
        val list=updateTvShowsUseCase.execute()
        emit(list)
    }
}