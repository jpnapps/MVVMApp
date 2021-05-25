package com.jpndev.retrofitdemo.network

import com.jpndev.mvvmdemo.data.model.MoviesList
import com.jpndev.mvvmdemo.data.model.StarList
import com.jpndev.mvvmdemo.data.model.TvShowsList
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apikey:String):Response<MoviesList>

    @GET("person/popular")
    suspend fun getPopularStarss(@Query("api_key")apikey:String):Response<StarList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apikey:String):Response<TvShowsList>




/*    @GET("/albums")
    suspend fun getAlbums():Response<MAlbums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id")id:Int):Response<MAlbumsItem>

    @POST("/albums")
    suspend fun postAlbum(@Body item:MAlbumsItem):Response<MAlbumsItem>*/
}