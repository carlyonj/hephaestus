package com.example.hephaestus.Contracts

import com.example.hephaestus.models.SolMeta
import com.example.hephaestus.presenters.BasePresenter
import com.example.hephaestus.views.BaseView

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadWeather()
    }

    interface View : BaseView<Presenter> {
        fun displayWeatherState(weatherState: SolMeta)
    }
}