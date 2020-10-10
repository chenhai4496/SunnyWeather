package com.sunnyweather.android

import android.app.Application
import android.content.Context

/**
 * To do 全局获取Context对象
 * @author      chenhai
 * @date        2020-10-10 13:22
 * @version     V1.0
 */
class SunnyWeatherApplication : Application(){

    companion object{
        lateinit var context: Context
        const val TOKEN = "填入你申请的令牌值1111"

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}