package com.handen.wetherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.handen.wetherapp.model.CitiesRepository

class CitiesViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = CitiesRepository(application)

}