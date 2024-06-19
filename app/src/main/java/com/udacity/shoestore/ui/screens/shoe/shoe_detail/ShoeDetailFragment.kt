package com.udacity.shoestore.ui.screens.shoe.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.ui.screens.shoe.ShoeViewModel


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: ShoeDetailFragmentBinding

    private val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        binding.btnSave.setOnClickListener {
            sharedViewModel.emptyShoe.apply {
                binding.editTextShoeName.text.toString()
                binding.editTextCompany.text.toString()
                binding.editTextDescription.text.toString()
                try {
                    binding.editTextShoeSize.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    val size = 0.0
                }
            }
            sharedViewModel.addShoe(sharedViewModel.emptyShoe)
            findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
        }

        return binding.root
    }

}