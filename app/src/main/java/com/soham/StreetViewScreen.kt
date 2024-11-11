package com.soham

import androidx.compose.runtime.Composable
import com.google.android.gms.maps.StreetViewPanoramaOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.streetview.StreetView
import com.google.maps.android.ktx.MapsExperimentalFeature

@OptIn(MapsExperimentalFeature::class)
@Composable
fun StreetViewScreen(){
    val LatLng = LatLng(19.123248521902095, 72.8361046720022)
    StreetView(
        streetViewPanoramaOptionsFactory = {
            StreetViewPanoramaOptions().position(LatLng)
        },
        isPanningGesturesEnabled = true,
        isStreetNamesEnabled = true,
        isUserNavigationEnabled = true,
        isZoomGesturesEnabled = true
    )
}