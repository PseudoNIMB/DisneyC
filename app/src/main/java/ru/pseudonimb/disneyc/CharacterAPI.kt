package ru.pseudonimb.disneyc

import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterAPI {
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): DataModel

}