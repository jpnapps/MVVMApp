package com.jpndev.mvvmdemo.presentation.di.core

import com.jpndev.retrofitdemo.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit:Retrofit):ApiService{
        return  retrofit.create(ApiService::class.java)
    }
}