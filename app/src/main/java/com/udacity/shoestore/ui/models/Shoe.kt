package com.udacity.shoestore.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val image: Int
)