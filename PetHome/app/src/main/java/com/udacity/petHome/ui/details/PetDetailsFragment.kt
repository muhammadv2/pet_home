package com.udacity.petHome.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.petHome.databinding.FragmentPetDetailsBinding
import com.udacity.petHome.ui.list.PetListViewModel
import android.view.View as View1


class PetDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPetDetailsBinding
    private val model: PetListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View1 {

        binding = FragmentPetDetailsBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Add new pet"

        binding.viewModel = model
        model.createClearPet()

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(
                PetDetailsFragmentDirections.actionPetDetailsFragmentToPetListFragment()
            )
        }

        model.closeScreen.observe(viewLifecycleOwner) { close ->
            close?.let {
                if (it) {
                    findNavController().navigateUp()
                    model.onCloseDone()
                }
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}

