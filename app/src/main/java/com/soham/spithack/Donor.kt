package com.soham.spithack

import com.google.android.gms.maps.model.LatLng

data class Donor(
    val name: String,
    val location: LatLng,
    val items: String,
    val quantity: String,
    val donorImage: String,
    val foodImage: String
)
