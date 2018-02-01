package com.sk.kotlinretrofit.rest

import com.sk.kotlinretrofit.model.Movie
import retrofit2.Call
import retrofit2.http.GET

/*
 * Created by Sambhaji Karad on 01-02-2018
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

interface ApiInterface {

    @GET("5a72d0b13100000f00a1d314")
    fun getMovieList(): Call<Movie>

}