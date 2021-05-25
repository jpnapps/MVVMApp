package com.jpndev.mvvmdemo.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="popular_stars")
data class Star(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("gender")
    val gender: Int,

    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String=""

/*    @SerializedName("adult")
val adult: Boolean,*/
/*    @SerializedName("known_for")
    val knownFor: List<KnownFor>,
    @SerializedName("known_for_department")
    val knownForDepartment: String,*/

)