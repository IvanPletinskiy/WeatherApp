package com.handen.wetherapp.location

import android.content.Context
import com.google.android.gms.location.LocationServices

class LocationManager(val context: Context) {
    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    init {
        fusedLocationClient.lastLocation.addOnSuccessListener {

        }
    }

}