package com.yusuferoglu.exchangerateapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yusuferoglu.exchangerateapp.R
import androidx.core.content.ContextCompat

class ExchangeRateAdapter(private val rates: Map<String, Double>) :
    RecyclerView.Adapter<ExchangeRateAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val currencyCode: TextView = view.findViewById(R.id.currencyCode)
        val currencyValue: TextView = view.findViewById(R.id.currencyValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val colors = arrayOf(R.color.firstColor, R.color.fivethColor, R.color.SColor, R.color.thirdolor, R.color.fourthColor)
        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, colors[position % colors.size]))


        val currency = rates.keys.elementAt(position)
        val rate = rates[currency]
        holder.currencyCode.text = currency
        holder.currencyValue.text = rate.toString()
    }

    override fun getItemCount(): Int {
        return rates.size
    }
}
