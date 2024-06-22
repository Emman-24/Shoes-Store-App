package com.udacity.shoestore.ui.models

import androidx.annotation.DrawableRes


data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    @DrawableRes var image: Int
)