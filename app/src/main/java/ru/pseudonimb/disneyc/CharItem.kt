package ru.pseudonimb.disneyc

data class CharItemModel (
    val data: DataModel
)

data class DataModel (
    val _id : Int,
    val name : String,
    val imageUrl: String,
    val url: String
)