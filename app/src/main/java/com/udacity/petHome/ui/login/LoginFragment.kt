package com.udacity.petHome.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.petHome.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(
            inflater, container,
            false
        )
        (activity as AppCompatActivity).supportActionBar?.title = "Sign In Or Sign Up"



        binding.signInBtn.setOnClickListener {
            view?.findNavController()
                ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }
        binding.registerBtn.setOnClickListener {
            view?.findNavController()
                ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }
        // Inflate the layout for this fragment
        return binding.root
    }


}