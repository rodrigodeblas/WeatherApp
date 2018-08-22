package com.projects.rodrixan.weatherapp.interactor

import com.projects.rodrixan.weatherapp.model.ForecastResult
import com.projects.rodrixan.weatherapp.model.domain.ForecastDataMapper
import com.projects.rodrixan.weatherapp.model.domain.ForecastList
import com.projects.rodrixan.weatherapp.repository.WeatherRepository
import com.projects.rodrixan.weatherapp.repository.WeatherRepositoryImpl
import com.projects.rodrixan.weatherapp.view.ForecastView

class ForecastPresenterImpl : ForecastPresenter, WeatherRepository.ForecastCallback {

    private lateinit var repository: WeatherRepository

    private lateinit var view: ForecastView

    override fun init(view: ForecastView) {
        this.view = view
        repository= WeatherRepositoryImpl()
    }

    override fun getForecastByCity(code: String) {
        repository.getForecastList(this, code)
    }

    override fun onForecastListReceived(results: ForecastList) {
        view.onForecastReceived(results)
    }

    override fun onError(error: String) {
        view.onError(error)
    }

}