package com.projects.rodrixan.weatherapp.base.rest

import com.projects.rodrixan.weatherapp.BuildConfig
import com.projects.rodrixan.weatherapp.base.GlobalConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class WeatherService {
    companion object Factory {
        fun create(): WeatherApi {
            val retrofit = Retrofit.Builder()
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(GlobalConstants.BASE_URL)
                    .build()

            return retrofit.create(WeatherApi::class.java)
        }

        private fun getClient(): OkHttpClient {
            return OkHttpClient().newBuilder()
                    .addInterceptor(QueryParamInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()
        }
    }

    class QueryParamInterceptor :
            Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val url = request.url().newBuilder()
                    .addQueryParameter(GlobalConstants.WEATHER_API_KEY_QUERY_PARAM,
                            GlobalConstants.WEATHER_API_KEY_QUERY_PARAM_VALUE)
                    .addQueryParameter(GlobalConstants.WEATHER_API_MODE_QUERY_PARAM,
                            GlobalConstants.WEATHER_API_MODE_QUERY_PARAM_VALUE)
                    .addQueryParameter(GlobalConstants.WEATHER_API_UNIT_QUERY_PARAM,
                            GlobalConstants.WEATHER_API_UNIT_QUERY_PARAM_VALUE)
                    .build()

            val newRequest = request.newBuilder()
                    .url(url)
                    .build()

            return chain.proceed(newRequest)
        }

    }
}
