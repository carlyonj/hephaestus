package com.example.hephaestus.contracts

import com.example.hephaestus.models.SolMeta
import com.example.hephaestus.presenters.BasePresenter
import com.example.hephaestus.views.BaseView

interface HistoryContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onLoadWeather(solMeta: SolMeta)
    }

    interface View : BaseView<Presenter> {
        fun displayWeatherState(weatherState: SolMeta)
    }
}