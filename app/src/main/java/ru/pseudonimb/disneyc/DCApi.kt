package ru.pseudonimb.disneyc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DCApi {
    @GET("3/movie/popular")
    fun getChars(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<DCResults>
}