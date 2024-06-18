package com.udacity.shoestore.ui.screens.shoe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.ui.models.Shoe
import org.w3c.dom.Text

class ShoeViewModel : ViewModel() {

    private val _shoeMenu = MutableLiveData<List<Shoe>>(
        mutableListOf()
//        listOf(
//            Shoe(
//                "Club Max",
//                42.0,
//                "Nike",
//                "Te presentamos la nueva generación de tecnología Air. Los Air Max Dn cuentan con nuestro sistema de unidades Dynamic Air de tubos de presión dual, lo que crea una sensación reactiva en cada pisada.",
//                R.drawable.nike_jordan
//            ),
//        )
    )
    val shoeMenu: LiveData<List<Shoe>> get() = _shoeMenu

    private val _shoeData = MutableLiveData<Shoe>()
    var shoeData: LiveData<Shoe> = _shoeData


}