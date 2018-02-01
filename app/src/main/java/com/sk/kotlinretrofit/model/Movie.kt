package com.sk.kotlinretrofit.model

/*
 * Created by Sambhaji Karad on 01-02-2018
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("messageId")
    @Expose
    var messageId: String? = null

    @SerializedName("messageText")
    @Expose
    var messageText: String? = null

    @SerializedName("movies")
    @Expose
    var moviesList: List<MovieList>? = null

    inner class MovieList {

        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("releaseDate")
        @Expose
        var releaseDate: String? = null

        @SerializedName("imageurl")
        @Expose
        var imageurl: String? = null
    }
}