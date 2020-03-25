package com.handen.wetherapp.api

import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

public class WeatherResponse {

    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("weather")
    var weather: List<Weather>? = null
    @SerializedName("base")
    var base: String? = null
    @SerializedName("main")
    lateinit var main: Main
    @SerializedName("wind")
    lateinit var _wind: Wind
    @SerializedName("clouds")
    var clouds: Clouds? = null
    @SerializedName("dt")
    var dt = 0
    @SerializedName("sys")
    var sys: Sys? = null
    @SerializedName("timezone")
    var timezone = 0
    @SerializedName("id")
    var id = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("cod")
    var cod = 0

    inner class Clouds {
        @SerializedName("all")
        var all = 0
    }

    inner class Coord {
        @SerializedName("lon")
        var lon = 0
        @SerializedName("lat")
        var lat = 0
    }

    inner class Main {
        @SerializedName("temp")
        var temp = 0.0
        @SerializedName("feels_like")
        var feelsLike = 0.0
        @SerializedName("temp_min")
        var tempMin = 0.0
        @SerializedName("temp_max")
        var tempMax = 0.0
        @SerializedName("pressure")
        var pressure = 0
        @SerializedName("humidity")
        var humidity = 0
    }

    inner class Sys {
        @SerializedName("type")
        var type = 0
        @SerializedName("id")
        var id = 0
        @SerializedName("message")
        var message = 0.0
        @SerializedName("country")
        var country: String? = null
        @SerializedName("sunrise")
        var sunrise = 0
        @SerializedName("sunset")
        var sunset = 0
    }

    inner class Weather {
        @SerializedName("id")
        var id = 0
        @SerializedName("main")
        var main: String? = null
        @SerializedName("description")
        var description: String? = null
        @SerializedName("icon")
        var icon: String? = null
    }

    inner class Wind {
        @SerializedName("speed")
        var speed = 0.0
        @SerializedName("deg")
        var deg = 0.0
    }
}

val WeatherResponse.temp: Int
    get() {
        return this.main.temp.roundToInt()
    }

val WeatherResponse.humidity: Int
    get() {
        return this.main.humidity
    }

val WeatherResponse.wind: Int
    get() {
        return this._wind.speed.roundToInt()
    }
