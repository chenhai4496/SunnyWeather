package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> create(serviceClass : Class<T>) : T {

        return retrofit.create(serviceClass)
    }

    //外部调用的方法
    inline fun <reified T> create() : T {

        return create(T ::class.java)
    }


}