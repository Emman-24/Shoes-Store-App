package com.udacity.shoestore.ui.screens.shoe.shoes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController().navigate(R.id.action_shoesListFragment_to_loginFragment)
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner)

        sharedViewModel.shoeMenu.observe(viewLifecycleOwner) { shoeList ->
            if (shoeList.isEmpty()) {
                val newView: EmptyListBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.empty_list,
                    null,
                    false
                )
                binding.listLayout.addView(newView.root)

            } else {
                shoeList.forEach { shoe ->
                    val newView: ShoeBinding = DataBindingUtil.inflate(
                        layoutInflater,
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
    }

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

        binding.btnAddShoe.setOnClickListener {
            findNavController().navigate(R.id.action_shoesList_to_shoeDetail)
        }

        return binding.root

    }

}