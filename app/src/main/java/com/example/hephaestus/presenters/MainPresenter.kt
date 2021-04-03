package com.example.hephaestus.presenters

import android.util.Log
import com.example.hephaestus.contracts.MainContract
import com.example.hephaestus.di.DaggerControllerComponent
import com.example.hephaestus.models.SolMeta

class MainPresenter(view: MainContract.View) :  MainContract.Presenter {
    private val weatherController = DaggerControllerComponent.builder().build().getController()

    private var view: MainContract.View? = view

    private fun loadWeather() {
        weatherController.start { solMeta : SolMeta ->
            onLoadWeather(solMeta)
        }
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadWeather()
    }

    override fun onLoadWeather(solMeta: SolMeta) {
        view?.displayWeatherState(solMeta)
    }
}