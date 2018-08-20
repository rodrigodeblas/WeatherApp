package com.projects.rodrixan.weatherapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.projects.rodrixan.weatherapp.R
import com.projects.rodrixan.weatherapp.view.adapter.ForecastListAdapter
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenter
import com.projects.rodrixan.weatherapp.interactor.ForecastPresenterImpl
import com.projects.rodrixan.weatherapp.model.domain.ForecastList
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), ForecastView {
    companion object {
        val TAG = MainActivity.javaClass.simpleName
    }

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

    override fun onForecastReceived(results: ForecastList) {
        runOnUiThread {
            forecast_list.adapter = ForecastListAdapter(results, {
                toast("Selected Forecast: ${it.description}")
            })
        }

    }


    override fun onError(error: String) {
        runOnUiThread {
            longToast(error)
        }
    }
}
