package ru.pseudonimb.disneyc

data class CharItem(
    val data: Data
)

data class Data (
    val _id : Int,
    val films : String,
    val shortFilms : String,
    val name : String
)