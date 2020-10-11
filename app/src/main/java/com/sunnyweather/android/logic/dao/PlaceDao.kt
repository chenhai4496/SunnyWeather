package com.sunnyweather.android.logic.dao

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place


object PlaceDao {


    private fun sharedPreference() : SharedPreferences{

        return SunnyWeatherApplication.context
            .getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
    }

    fun isPlaceSave() = sharedPreference().contains("place")

    fun savePlace(place : Place){
        sharedPreference().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace() : Place{
        val placeJson = sharedPreference().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }


}