package com.handen.wetherapp.model

import android.app.Application

class CitiesRepository(application: Application) {
    private var cityDao: CityDao

    //private var allNotes: LiveData<List<Note>>

    init {
        val database: CityDatabase = CityDatabase.getInstance(
            application.applicationContext
        )!!
        cityDao = database.cityDao()
        //allNotes = noteDao.getAllNotes()
    }
}