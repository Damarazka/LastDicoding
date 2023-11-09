package com.damarazka.lastdicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
