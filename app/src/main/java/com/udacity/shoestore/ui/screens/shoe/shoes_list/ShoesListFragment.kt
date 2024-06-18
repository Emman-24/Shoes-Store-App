package com.udacity.shoestore.ui.screens.shoe.shoes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.EmptyListBinding
import com.udacity.shoestore.databinding.ShoeBinding
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.ui.screens.shoe.ShoeViewModel

class ShoesListFragment : Fragment() {

    private lateinit var binding: ShoesListFragmentBinding

    private val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoes_list_fragment,
            container,
            false
        )


        sharedViewModel.shoeMenu.observe(viewLifecycleOwner) { shoeList ->
            if (shoeList.isEmpty()) {
                val newView: EmptyListBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.empty_list,
                    null,
                    false
                )
                binding.listLayout.addView(newView.root)

            } else {
                shoeList.forEach { shoe ->
                    val newView: ShoeBinding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.shoe,
                        null,
                        false
                    )
                    newView.tvShoeName.text = shoe.name
                    newView.tvShoeCompany.text = shoe.company
                    newView.tvShoeSize.text = shoe.size.toString()
                    newView.tvDescription.text = shoe.description
                    newView.imageView.setImageResource(shoe.image)
                    binding.listLayout.addView(newView.root)
                }
            }
        }


        binding.btnAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoesList_to_shoeDetail)
        }

        return binding.root
    }

}