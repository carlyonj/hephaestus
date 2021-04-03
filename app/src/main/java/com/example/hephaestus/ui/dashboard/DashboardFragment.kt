package com.example.hephaestus.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import com.example.hephaestus.R
import com.example.hephaestus.contracts.HistoryContract
import com.example.hephaestus.models.SolMeta
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment(), HistoryContract.View {
    internal lateinit var presenter: HistoryContract.Presenter
    internal lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_history, container, false)
//        tempText = root.findViewById(R.id.temp_val)
//        pressureText = root.findViewById(R.id.pressure_val)
//
//        setPresenter(MainPresenter(this))
        presenter.onViewCreated()
        listView = root.findViewById(R.id.list_view)

        return root
    }

    override fun displayWeatherState(weatherState: SolMeta) {
        //listView.adapter = ListAda
    }

    override fun setPresenter(presenter: HistoryContract.Presenter) {
        TODO("Not yet implemented")
    }

//    private class ListAdapter(val solMeta: SolMeta) : BaseAdapter() {
//        override fun getCount(): Int {
//            return solMeta.solList.size
//        }
//
//        override fun getItem(position: Int): Any {
//            return solMeta.solList[position]
//        }
//
//        override fun getItemId(position: Int): Long {
//            return position.toLong()
//        }
//
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            if (convertView == null) {
//                val inflater = LayoutInflater.from(parent!!.context)
//                val view = inflater.inflate(R.layout.history_list_item, parent, false)
//
//            }
//        }
//
//    }
}
