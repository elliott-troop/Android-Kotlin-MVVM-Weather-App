package com.elliott.forecastmvvm.data.db.network.response

import com.elliott.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.elliott.forecastmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)