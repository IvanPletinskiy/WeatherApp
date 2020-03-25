package com.handen.wetherapp.model

import android.app.Application
import androidx.lifecycle.LiveData

class CitiesRepository(application: Application) {
    private var cityDao: CityDao

    init {
        val database: CityDatabase = CityDatabase.getInstance(
            application.applicationContext
        )!!
        cityDao = database.cityDao()
    }

    fun getCitiesLiveData(): LiveData<MutableList<City>> = cityDao.getAllCities()

    fun addCity(city: City) = cityDao.addOrUpdateCity(city)
}