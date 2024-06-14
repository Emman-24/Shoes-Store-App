package com.udacity.shoestore.ui.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instructions_fragment, container, false
        )

        binding.btnInstructions.setOnClickListener {
            findNavController().navigate(R.id.action_instructions_to_shoes_list)
        }
        return binding.root
    }

}