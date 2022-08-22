package com.udacity.petHome.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet(
    var name: String, var group: String, var age: String, var description: String
) : Parcelable