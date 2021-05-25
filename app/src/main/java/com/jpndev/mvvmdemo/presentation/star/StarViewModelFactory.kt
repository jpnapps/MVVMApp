package com.jpndev.mvvmdemo.presentation.star

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jpndev.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.GetStarsUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateStarsUseCase

class StarViewModelFactory  (private val getStarsUseCase: GetStarsUseCase,
                             private val updateStarsUseCase: UpdateStarsUseCase
) :ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return StarViewModel(getStarsUseCase,updateStarsUseCase)as T
    }

}