package ru.pseudonimb.disneyc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Char(
    val title: String,
    val poster: Int,
    val description: String
) : Parcelable
