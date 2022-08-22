package com.udacity.petHome.ui.list

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.petHome.R
import com.udacity.petHome.databinding.CardPetBinding
import com.udacity.petHome.databinding.FragmentPetListBinding
import com.udacity.petHome.models.Pet
import timber.log.Timber

const val FIRST_LUNCH_PREF_KEY = "FIRST_LAUNCH"
const val FIRST_LUNCH_BOOL_KEY = "IS_IT_FIRST_LAUNCH"


class PetListFragment : Fragment() {


    private lateinit var binding: FragmentPetListBinding
    private val model: PetListViewModel by activityViewModels()


    private fun checkIfFirstLunch(container: ViewGroup?) {
        val sharedPreference =
            activity?.getSharedPreferences(FIRST_LUNCH_PREF_KEY, Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreference!!.getBoolean(FIRST_LUNCH_BOOL_KEY, true)

        if (isFirstLaunch) {
            container?.findNavController()
                ?.navigate(PetListFragmentDirections.actionPetListFragmentToLoginFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPetListBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Pet List"

        checkIfFirstLunch(container)

        binding.fab.setOnClickListener {
            findNavController().navigate(
                PetListFragmentDirections.actionPetListFragmentToPetDetailsFragment2()
            )
        }

        model.pets.observe(viewLifecycleOwner) {
            it?.let {
                displayShoes(it)
            }
        }
        return binding.root
    }

    private fun displayShoes(pets: List<Pet>) {

        pets.forEach { displayShoe(it) }
    }

    private fun displayShoe(pet: Pet) {
        val petBinding: CardPetBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_pet, null, false)

//        petBinding.viewModel = model
        petBinding.petName.text = pet.name
        petBinding.petGroup.text = pet.group
        petBinding.petAge.text = pet.age
        petBinding.petDescription.text = pet.description

        binding.listContainer.addView(petBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logOut) {
            val sharedPreference =
                activity?.getSharedPreferences(FIRST_LUNCH_PREF_KEY, Context.MODE_PRIVATE)
            val editor = sharedPreference?.edit()
            editor?.putBoolean(FIRST_LUNCH_BOOL_KEY, true)
            editor?.apply()
            findNavController()
                .navigate(PetListFragmentDirections.actionPetListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }
}