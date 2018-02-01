package com.sk.kotlinretrofit.rest

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * Created by Sambhaji Karad on 01-02-2018
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

object ApiClient {

    const val BASE_URL = "http://www.mocky.io/v2/"
    private var retrofit: Retrofit? = null

    private val gson = GsonBuilder()
            .setLenient()
            .create()

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }

        return retrofit
    }
}
