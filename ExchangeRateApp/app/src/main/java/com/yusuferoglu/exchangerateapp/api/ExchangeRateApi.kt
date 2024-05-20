package com.yusuferoglu.exchangerateapp.api

import com.yusuferoglu.exchangerateapp.model.ExchangeRateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateApi {
    @GET("latest/{base}")
    fun getExchangeRates(@Path("base") base: String): Call<ExchangeRateResponse>
}