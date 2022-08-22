package com.udacity.petHome.ui.instructions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.udacity.petHome.databinding.FragmentInstructionsBinding
import com.udacity.petHome.ui.list.FIRST_LUNCH_BOOL_KEY
import com.udacity.petHome.ui.list.FIRST_LUNCH_PREF_KEY
import kotlinx.android.synthetic.main.activity_main.*


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentInstructionsBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title = "Instruction"

        binding.gettingStartedBtn.setOnClickListener {

            val sharedPreference =
                activity?.getSharedPreferences(FIRST_LUNCH_PREF_KEY, Context.MODE_PRIVATE)
            val editor = sharedPreference?.edit()
            editor?.putBoolean(FIRST_LUNCH_BOOL_KEY, false)
            editor?.apply()
            view?.findNavController()
                ?.navigate(
                    InstructionsFragmentDirections.actionInstructionsFragmentToPetListFragment2()
                )
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}