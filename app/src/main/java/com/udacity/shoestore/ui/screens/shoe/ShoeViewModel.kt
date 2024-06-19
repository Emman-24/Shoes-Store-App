package com.udacity.shoestore.ui.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeMenu = MutableLiveData<List<Shoe>>()
    val shoeMenu: LiveData<List<Shoe>> = _shoeMenu


    init {
        _shoeMenu.value = emptyList()
    }

    fun addShoe(shoe: Shoe) {
        val currentList = _shoeMenu.value ?: emptyList()
        _shoeMenu.value = currentList + shoe
    }

    private fun shoesImage(): List<Int> {
        return listOf(
            R.drawable.nike_air_max,
            R.drawable.nike_air_maxi,
            R.drawable.nike_club_max,
            R.drawable.nike_jordan
        )
    }

    fun getRandomShoeImageResource(): Int {
        return shoesImage().random()
    }
}