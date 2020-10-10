package com.sunnyweather.android.ui.place

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class PlaceViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        //在这里创建MainViewModel实例，因为create()方法执行和Activity的生命周期无关
        return PlaceViewModel() as T
    }
}