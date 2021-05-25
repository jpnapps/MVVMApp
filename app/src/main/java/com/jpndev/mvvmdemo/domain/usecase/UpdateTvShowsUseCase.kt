package com.jpndev.mvvmdemo.domain.usecase


import com.jpndev.mvvmdemo.data.model.TvShow
import com.jpndev.mvvmdemo.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>?=tvShowRepository.updatedTvShows()

}