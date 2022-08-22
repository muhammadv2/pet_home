package com.udacity.petHome.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.petHome.models.Pet
import timber.log.Timber
import java.sql.Time

class PetListViewModel : ViewModel() {

    var newPet = MutableLiveData<Pet>()

    private val _pet = MutableLiveData<List<Pet>>()

    val pets: LiveData<List<Pet>>
        get() = _pet

    private val _closeScreen = MutableLiveData<Boolean>()
    val closeScreen: LiveData<Boolean>
        get() = _closeScreen

    fun onCloseDone() {
        _closeScreen.value = false
    }

    init {
        newPet = MutableLiveData(Pet("", "", "", ""))
    }

    fun save() {
        val pets = mutableListOf<Pet>()

        _pet.value?.forEach() {
            Timber.d(it.name)
            pets.add(it)
        }

        Timber.d(pets.size.toString())
        newPet.value?.let {
            pets.add(it)
        }

        _pet.value = pets

        _closeScreen.value = true

    }


}