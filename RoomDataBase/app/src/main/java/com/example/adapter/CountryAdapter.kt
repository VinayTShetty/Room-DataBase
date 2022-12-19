package com.example.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.Countries
import com.example.roomdatabase.R

class CountryAdapter(val activity: Activity) :
    RecyclerView.Adapter<CountryAdapter.CountryItemViewHolder>() {

    private var countryList: List<Countries>? = null

    fun setCountryList(loc_countrylist: List<Countries>) {
        this.countryList = loc_countrylist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return CountryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.bindData(countryList?.get(position), activity)
    }

    override fun getItemCount(): Int {
                if(countryList==null){
                return 0
                }else return countryList!!.size
    }

    class CountryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val tvCapital = itemView.findViewById<TextView>(R.id.tvCapital)
        val tvRegion = itemView.findViewById<TextView>(R.id.tvRegion)

        fun bindData(data: Countries?, activity: Activity) {
            tvname.text = data!!.name + " " + data!!.alpha2Code
            tvCapital.text = "Capital " + data.capital
            tvRegion.text = "Region " + data.region
            Glide.with(activity)
                .load(data.flags?.png)
                .into(flagImage)
        }
    }
}