package com.projects.rodrixan.weatherapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.adapter.ForecastListAdapter
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenter
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenterImpl
import com.projects.rodrixan.weatherapp.model.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.runOnUiThread

class MainActivity : AppCompatActivity(), ForecastView {

    private val presenter: ForecastPresenter by lazy { ForecastPresenterImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        forecast_list.layoutManager = LinearLayoutManager(this)
        doAsync {
            presenter?.getForecastByCity("94043")
        }
    }

    override fun onForecastReceived(results: List<Forecast>) {
        runOnUiThread {
            forecast_list.adapter = ForecastListAdapter(results)
        }

    }

    override fun onError(error: String) {
        runOnUiThread {
            longToast(error)
        }
    }
}
