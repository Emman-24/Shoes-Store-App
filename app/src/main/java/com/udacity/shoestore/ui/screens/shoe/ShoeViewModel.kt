package com.udacity.shoestore.ui.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.models.Shoe

class ShoeViewModel : ViewModel() {


    private val _shoeMenu = MutableLiveData<List<Shoe>>()
    val shoeMenu: LiveData<List<Shoe>> = _shoeMenu

    private val _shoeData = MutableLiveData<Shoe>()
    var shoeData: LiveData<Shoe> = _shoeData

    val emptyShoe = Shoe("", 0.0, "", "", R.drawable.ic_launcher_foreground)

    init {
        _shoeMenu.value = emptyList()
    }

    fun addShoe(shoe: Shoe) {
        val currentList = _shoeMenu.value ?: emptyList()
        _shoeMenu.value = currentList + shoe
    }
}