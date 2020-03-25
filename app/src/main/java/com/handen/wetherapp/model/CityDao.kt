package com.handen.wetherapp.model

import androidx.room.*

@Dao
interface CityDao {
    @Query("SELECT * FROM cities_table")
    fun getAllCities(): List<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrUpdateCity(city: City)

    @Delete
    fun deleteCity(city: City)

    @Query("SELECT last_fetched FROM cities_table WHERE id = :id")
    fun getLastFetched(id: Int): Long
}