package com.udacity.petHome.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.udacity.petHome.databinding.WelcomeFragmentBinding


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = WelcomeFragmentBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title = "Welcome"

        binding.gettingStartedBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        )
        // Inflate the layout for this fragment
        return binding.root
    }


}