package com.handen.wetherapp.viewmodel

import android.app.Application
import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.handen.wetherapp.api.*
import com.handen.wetherapp.model.CitiesRepository
import com.handen.wetherapp.model.City
import retrofit2.Call
import retrofit2.Response
import java.util.*


class CitiesViewModel(application: Application) : AndroidViewModel(application) {
    private var repository = CitiesRepository(application)
    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application.applicationContext)
    private val weatherApi: WeatherApi = ApiClient.getInstance().create(WeatherApi::class.java)

    init {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            val lat = it.latitude
            val lon = it.longitude
            val gcd = Geocoder(application.applicationContext, Locale.getDefault())
            val addresses: List<Address>

            addresses = gcd.getFromLocation(lat, lon, 1)
            if (addresses.isNotEmpty()) {
                val address =
                    addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                val cityName = addresses[0].getLocality()
                val subLocality = addresses[0].getSubLocality()
                val state = addresses[0].getAdminArea()
                val country = addresses[0].getCountryName()
                val postalCode = addresses[0].getPostalCode()
                val knownName = addresses[0].getFeatureName()
                /*
                if (subLocality != null) {
                    currentLocation = "$locality,$subLocality"
                } else {
                    currentLocation = locality
                }
                current_locality = locality

                 */
                citiesLiveData.value?.none { it.name == cityName }.let {
                    addNewCity(cityName, lat, lon)
                }
            }
        }
    }

    private fun addNewCity(cityName: String, lat: Double, lon: Double) {
        weatherApi.getCityWeather(lat, lon).enqueue(object : retrofit2.Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<WeatherResponse>?,
                response: Response<WeatherResponse>?
            ) {
                response?.let {
                    if(it.isSuccessful) {
                        val weatherResponse = response.body()
                        val temp = weatherResponse.temp
                        val humidity = weatherResponse.humidity
                        val wind = weatherResponse.wind
                        val city = City(cityName, lat, lon, temp, humidity, wind, Date().time)
                        repository.addCity(city)
                    }
                }
            }
        })
    }

    val citiesLiveData: LiveData<MutableList<City>> = repository.getCitiesLiveData()

    val selectedCityLiveData: MutableLiveData<City> = MutableLiveData<City>().apply {

    }
}