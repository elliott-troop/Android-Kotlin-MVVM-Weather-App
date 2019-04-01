package com.elliott.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elliott.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.elliott.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.elliott.forecastmvvm.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.elliott.forecastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
//    Method to update or insert into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

//    Returns LiveData, used to observe changes made with the current_weather_entry from other classes dealing with the UI
    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}