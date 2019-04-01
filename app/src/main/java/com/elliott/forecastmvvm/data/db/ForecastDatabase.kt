package com.elliott.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elliott.forecastmvvm.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    //    Database needs to be a singleton
    companion object {

        //        @Volatile is used so all threads will have immediate access to this property instance
        @Volatile
        private var instance: ForecastDatabase? = null

        //        Created due to muli-thread usagage
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            If the instance variable is null, then we want to build the database and assign the instance variable to it
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
//            Creates a database and names it forecast.db
            Room.databaseBuilder(
                context.applicationContext,
                ForecastDatabase::class.java, "forecast.db"
            )
                .build()
    }
}