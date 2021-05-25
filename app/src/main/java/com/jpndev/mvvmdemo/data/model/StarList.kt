package com.jpndev.mvvmdemo.data.model


import com.google.gson.annotations.SerializedName

data class StarList(

    @SerializedName("results")
    val stars: List<Star>

 /*   @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int*/
)