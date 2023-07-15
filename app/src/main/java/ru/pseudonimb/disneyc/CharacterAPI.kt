package ru.pseudonimb.disneyc

import retrofit2.http.GET

interface CharacterAPI {
    @GET("character/11")
    suspend fun getCharacterById(): CharItemModel

}