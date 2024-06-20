package com.udacity.shoestore.ui.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        fun validateEmptyFields(email: String, pass: String): Boolean {
            var isValid = true
            if (email.isEmpty()) {
                binding.editTextEmail.error = "Email is required"
                isValid = false
            } else {
                binding.editTextEmail.error = null
            }
            if (pass.isEmpty()) {
                binding.editTextPass.error = "Password is required"
                isValid = false
            } else {
                binding.editTextPass.error = null
            }
            return isValid
        }

        binding.btnSignIn.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPass.text.toString().trim()

            if (validateEmptyFields(email, password)) {
                navigateToWelcome()
            }

        }


        binding.btnCreateAccount.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPass.text.toString().trim()

            if (validateEmptyFields(email, password)) {
                navigateToWelcome()
            }
        }


        return binding.root
    }

    private fun navigateToWelcome() {
        findNavController().navigate(R.id.action_login_to_welcome)
    }


}