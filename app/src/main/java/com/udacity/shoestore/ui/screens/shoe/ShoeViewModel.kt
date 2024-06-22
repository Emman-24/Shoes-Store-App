package com.udacity.shoestore.ui.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.models.Shoe

class ShoeViewModel : ViewModel() {

    private var _shoeMenu = MutableLiveData<List<Shoe>>()
    val shoeMenu: LiveData<List<Shoe>> = _shoeMenu

    private var _isShoeAdded = MutableLiveData<Boolean>()
    val isShoeAdded: LiveData<Boolean> = _isShoeAdded

    val newShoeName = MutableLiveData<String>()
    val newShoeSize = MutableLiveData<String>()
    val newShoeCompany = MutableLiveData<String>()
    val newShoeDescription = MutableLiveData<String>()


    init {
        _shoeMenu.value = emptyList()
    }


    fun addShoe() {
        val newShoe = Shoe(
            name = newShoeName.value ?: "",
            size = newShoeSize.value?.toDoubleOrNull() ?: 0.0,
            company = newShoeCompany.value ?: "",
            description = newShoeDescription.value ?: "",
            image = getRandomShoeImageResource()

        )
        val currentList = _shoeMenu.value ?: emptyList()
        _shoeMenu.value = currentList + newShoe
        _isShoeAdded.value = true
        resetNewShoe()
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

    fun resetIsShoeAdded() {
        _isShoeAdded.value = false
    }

    private fun resetNewShoe() {
        newShoeName.value = ""
        newShoeSize.value = ""
        newShoeCompany.value = ""
        newShoeDescription.value = ""
    }
}