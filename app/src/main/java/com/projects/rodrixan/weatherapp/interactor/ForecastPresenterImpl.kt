package com.projects.rodrixan.weatherapp.interactor

import com.projects.rodrixan.weatherapp.model.ForecastResult
import com.projects.rodrixan.weatherapp.model.domain.ForecastDataMapper
import com.projects.rodrixan.weatherapp.repository.WeatherRepository
import com.projects.rodrixan.weatherapp.repository.WeatherRepositoryImpl
import com.projects.rodrixan.weatherapp.view.ForecastView

class ForecastPresenterImpl : ForecastPresenter, WeatherRepository.ForecastCallback {

    private val repository: WeatherRepository by lazy { WeatherRepositoryImpl() }

    private var view: ForecastView? = null

    override fun init(view: ForecastView) {
        this.view = view
    }

    override fun getForecastByCity(code: String) {
        repository?.getForecastList(this, code)
    }

    override fun onForecastListReceived(results: ForecastResult) {
        view?.onForecastReceived(ForecastDataMapper().convertFromDataModel(results))
    }

    override fun onError(error: String) {
        view?.onError(error)
    }

}