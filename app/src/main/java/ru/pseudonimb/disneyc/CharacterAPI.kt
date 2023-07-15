package ru.pseudonimb.disneyc

import retrofit2.http.GET

interface CharacterAPI {
    @GET("character/11")
    fun getCharacterById(): CharItem

}