package com.jpndev.mvvmdemo.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jpndev.mvvmdemo.domain.usecase.GetMoviesUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateMoviesUseCase

class MovieViewModel( private val getMoviesUseCase: GetMoviesUseCase,
                      private val updateMoviesUseCase: UpdateMoviesUseCase
) :ViewModel (){

    fun getMovies()= liveData {
        val list=getMoviesUseCase.execute()
        emit(list)
    }

    fun updateMovies()= liveData {
        val list=updateMoviesUseCase.execute()
        emit(list)
    }
}