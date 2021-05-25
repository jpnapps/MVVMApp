package com.jpndev.mvvmdemo.presentation.star

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jpndev.mvvmdemo.domain.usecase.GetStarsUseCase
import com.jpndev.mvvmdemo.domain.usecase.UpdateStarsUseCase

class StarViewModel(private val getStarsUseCase: GetStarsUseCase,
                    private val updateStarsUseCase: UpdateStarsUseCase
) :ViewModel (){

    fun getStars()= liveData {
        val list=getStarsUseCase.execute()
        emit(list)
    }

    fun updateStars()= liveData {
        val list=updateStarsUseCase.execute()
        emit(list)
    }
}