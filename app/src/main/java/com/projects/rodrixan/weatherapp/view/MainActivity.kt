package com.projects.rodrixan.weatherapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenter
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenterImpl
import com.projects.rodrixan.weatherapp.model.domain.ForecastList
import com.projects.rodrixan.weatherapp.view.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), ForecastView {

    private lateinit var presenter: ForecastPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initPresenter()
        initRecyclerView()
        callForData()
    }

    private fun initPresenter() {
        presenter = ForecastPresenterImpl()
        presenter.init(this)
    }

    private fun initRecyclerView() {
        forecastList.layoutManager = LinearLayoutManager(this)
    }

    private fun callForData() {
        doAsync {
            presenter.getForecastByCity("94043")
        }
    }

    override fun onForecastReceived(results: ForecastList) {
        runOnUiThread {
            forecastList.adapter = ForecastListAdapter(results) {
                toast("Selected Forecast: ${it.description}")
            }
        }

    }


    override fun onError(error: String) {
        runOnUiThread {
            longToast(error)
        }
    }
}
