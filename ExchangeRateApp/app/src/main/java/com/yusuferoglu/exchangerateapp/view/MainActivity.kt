package com.yusuferoglu.exchangerateapp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusuferoglu.exchangerateapp.R
import com.yusuferoglu.exchangerateapp.api.RetrofitClient
import com.yusuferoglu.exchangerateapp.model.ExchangeRateResponse
import com.yusuferoglu.exchangerateapp.view.ExchangeRateAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getExchangeRates()
    }

    private fun getExchangeRates() {
        val call = RetrofitClient.api.getExchangeRates("USD")
        call.enqueue(object : Callback<ExchangeRateResponse> {
            override fun onResponse(call: Call<ExchangeRateResponse>, response: Response<ExchangeRateResponse>) {
                if (response.isSuccessful) {
                    val exchangeRates = response.body()?.rates
                    exchangeRates?.let {
                        recyclerView.adapter = ExchangeRateAdapter(it)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to get exchange rates", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ExchangeRateResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
