package com.jpndev.mvvmdemo.domain.repository


import com.jpndev.mvvmdemo.data.model.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>
    suspend fun updatedTvShows():List<TvShow>
}