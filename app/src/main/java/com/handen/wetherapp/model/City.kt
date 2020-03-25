package com.handen.wetherapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities_table")
data class City (
    var name: String,
    var lat: Double,
    var long: Double,
    var temp: Int,
    var humility: Int,
    var wind: Int,
    @ColumnInfo(name = "last_fetched")
    var lastFetched: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}