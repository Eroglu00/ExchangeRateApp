package com.yusuferoglu.exchangerateapp.model

import com.google.gson.annotations.SerializedName

data class ExchangeRateResponse(

    @SerializedName("currency") val base: String,

    @SerializedName("conversion_rates") val rates: Map<String, Double>
)