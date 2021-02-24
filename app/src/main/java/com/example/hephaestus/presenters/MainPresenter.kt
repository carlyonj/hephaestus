package com.example.hephaestus.presenters

import android.util.Log
import com.example.hephaestus.Contracts.MainContract
import com.example.hephaestus.di.DaggerControllerComponent

class MainPresenter(view: MainContract.View) :  MainContract.Presenter {
    private val weatherController = DaggerControllerComponent.builder().build().getController()

    private var view: MainContract.View? = view

    private fun loadWeather() {
        weatherController.start {
            onLoadWeather()
        }
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadWeather()
    }

    override fun onLoadWeather() {
        Log.e("zzz", "zzz onLoadWeather")
        //view?.displayWeatherState()
    }
}