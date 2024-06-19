package com.udacity.shoestore.ui.models

import android.graphics.drawable.Drawable


data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
     var image: Drawable
)