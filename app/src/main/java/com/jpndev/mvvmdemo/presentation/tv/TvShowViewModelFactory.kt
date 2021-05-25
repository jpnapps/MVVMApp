package com.jpndev.mvvmdemo.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jpndev.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.GetTvshowsUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory  (private val getTvshowsUseCase: GetTvshowsUseCase,
                               private val updateTvShowsUseCase: UpdateTvShowsUseCase
) :ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return TvShowViewModel(getTvshowsUseCase,updateTvShowsUseCase)as T
    }

}