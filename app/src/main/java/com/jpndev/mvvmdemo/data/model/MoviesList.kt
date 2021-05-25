package com.jpndev.mvvmdemo.data.model


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results")
    val movies: List<Movie>
/*    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int*/
)