package com.udacity.shoestore.ui.screens.shoe.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.ui.screens.shoe.ShoeViewModel


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: ShoeDetailFragmentBinding

    private lateinit var sharedViewModel: ShoeViewModel

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
        sharedViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.shoeViewModel = sharedViewModel

        sharedViewModel.isShoeAdded.observe(viewLifecycleOwner) { isAdded ->
            if (isAdded) {
                findNavController().navigate(R.id.action_shoeDetail_to_shoesList)
                sharedViewModel.resetIsShoeAdded()
            }
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