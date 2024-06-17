package com.udacity.shoestore.ui.screens.shoe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding


class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeDetailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
        }
        return binding.root
    }

}