package com.example.hephaestus.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hephaestus.Contracts.MainContract
import com.example.hephaestus.R
import com.example.hephaestus.api.Controller
import com.example.hephaestus.di.DaggerControllerComponent
import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.example.hephaestus.presenters.MainPresenter

class HomeFragment : Fragment(), MainContract.View {
    var solList: Array<SolData> = Array(7) {
        SolData()
    }
    internal lateinit var presenter: MainContract.Presenter
    internal lateinit var textView:  TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        textView = root.findViewById(R.id.text_home)

        setPresenter(MainPresenter(this))
        presenter.onViewCreated()

        return root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayWeatherState(weatherState: SolMeta) {
        val string: String = "Temperature: " + weatherState.solList.get(0).temperature.average
        Log.e("zzz", "zzz setWeather")
        textView.setText(string)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }


}
