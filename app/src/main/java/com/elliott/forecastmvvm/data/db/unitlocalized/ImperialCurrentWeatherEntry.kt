package com.elliott.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

// Implements the interface UnitSpecificCurrentWeatherEntry
data class ImperialCurrentWeatherEntry(

//    each @ColumnInfo tells this class what's the name of the property coming from the CurrentWeatherEntry
    @ColumnInfo(name = "tempF")
    override val temperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "windMph")
    override val windSpeed: Double,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precipIn")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslikeF")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visMiles")
    override val visibilityDistance: Double

): UnitSpecificCurrentWeatherEntry