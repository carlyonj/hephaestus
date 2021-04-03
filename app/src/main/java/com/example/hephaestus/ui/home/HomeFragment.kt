package com.example.hephaestus.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hephaestus.contracts.MainContract
import com.example.hephaestus.R
import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.example.hephaestus.presenters.MainPresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), MainContract.View {
    var solList: Array<SolData> = Array(7) {
        SolData()
    }
    internal lateinit var presenter: MainContract.Presenter
    internal lateinit var tempText:  TextView
    internal lateinit var pressureText:  TextView
    internal lateinit var solText:  TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        tempText = root.findViewById(R.id.temp_val)
        pressureText = root.findViewById(R.id.pressure_val)
        solText = root.findViewById(R.id.sol_val)

        setPresenter(MainPresenter(this))
        presenter.onViewCreated()

        return root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayWeatherState(weatherState: SolMeta) {
        tempText.setText(weatherState.solList[0].temperature.average)
        pressureText.setText(weatherState.solList[0].pressure.average)
        solText.setText(weatherState.solList[0].sol)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }


}
