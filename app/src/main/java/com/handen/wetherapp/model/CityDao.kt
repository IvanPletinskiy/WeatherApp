package com.handen.wetherapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CityDao {
    @Query("SELECT * FROM cities_table")
    fun getAllCities(): LiveData<MutableList<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrUpdateCity(city: City)

    @Delete
    fun deleteCity(city: City)

    @Query("SELECT last_fetched FROM cities_table WHERE id = :id")
    fun getLastFetched(id: Int): Long
}