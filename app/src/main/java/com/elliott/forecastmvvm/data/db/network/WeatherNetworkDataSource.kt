package com.elliott.forecastmvvm.data.db.network

import androidx.lifecycle.LiveData
import com.elliott.forecastmvvm.data.db.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}