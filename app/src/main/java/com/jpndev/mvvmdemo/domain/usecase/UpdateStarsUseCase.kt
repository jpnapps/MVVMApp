package com.jpndev.mvvmdemo.domain.usecase

import com.jpndev.mvvmdemo.data.model.Star
import com.jpndev.mvvmdemo.domain.repository.StarRepository

class UpdateStarsUseCase(private val starRepository: StarRepository) {

    suspend fun execute():List<Star>?=starRepository.updatedStars()
}