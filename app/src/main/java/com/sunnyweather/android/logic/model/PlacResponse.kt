package com.sunnyweather.android.logic.model


import com.google.gson.annotations.SerializedName


data class Location(val lng : String, val lat : String)


data class Place(val name : String, val location : Location,
                 @SerializedName("formatted_address") val address : String)


data class PlaceResponse(val status : String, val places : List<Place>)









