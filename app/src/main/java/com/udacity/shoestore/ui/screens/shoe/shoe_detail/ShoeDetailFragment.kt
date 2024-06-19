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
import com.udacity.shoestore.ui.models.Shoe
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
            val name = binding.editTextShoeName.text.toString()
            val company = binding.editTextCompany.text.toString()
            val description = binding.editTextDescription.text.toString()
            val image = binding.shoeImage.drawable
            val size = try {
                binding.editTextShoeSize.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                0.0
            }
            val newShoe = Shoe(name, size, company, description, image)
            sharedViewModel.addShoe(newShoe)
            findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
        }

        binding.shoeImage.setOnClickListener {
            sharedViewModel.getRandomShoeImageResource().let { imageResource ->
                binding.shoeImage.setImageResource(imageResource)
            }
        }


        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
        }

        return binding.root
    }

}