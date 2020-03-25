package com.handen.wetherapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    companion object {
        private const val apiKey = "08ab528f5e34cd45c5dc9566710e1a7d"
    }

    @GET("/data/2.5/weather?lat={lat}&lon=139&appid=$apiKey")
    fun getCityWeather(@Path("lat") lat: Long, @Path("lon") lon: Long): Call<WeatherResponse>
}