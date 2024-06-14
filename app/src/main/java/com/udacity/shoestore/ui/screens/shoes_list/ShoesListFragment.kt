package com.udacity.shoestore.ui.screens.shoes_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoesListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_list_fragment, container, false
        )
        return binding.root
    }

}