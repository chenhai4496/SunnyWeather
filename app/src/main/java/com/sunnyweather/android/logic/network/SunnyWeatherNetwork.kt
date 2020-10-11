package com.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


object SunnyWeatherNetwork {

    //调用Retrofit构造器,创建动态代理对象
    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query : String) = placeService.searchPlaces(query).await22()


    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun getRealtimeWeather(lng : String, lat : String)
            = weatherService.getRealtimeWeather(lng, lat).await22()

    suspend fun getDailyWeather(lng : String, lat : String)
            = weatherService.getDailyWeather(lng, lat).await22()


    private suspend fun <T> Call<T>.await22() : T{

        return suspendCoroutine { continuation ->

            enqueue(object : Callback<T>{
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                   val body = response.body()

                    if(body != null){
                        continuation.resume(body)

                    }else{
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }


                }

            })
        }
    }
}