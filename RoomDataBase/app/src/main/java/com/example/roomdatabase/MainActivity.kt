package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ViewModel.CountryViewModel
import com.example.adapter.CountryAdapter

class MainActivity : AppCompatActivity() {

    lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userdata_list)
        initRecycleView()
        initViewModel()
    }

    private fun initViewModel() {
        val countryRecycleView = findViewById<RecyclerView>(R.id.countryLisRecycleView)
        countryRecycleView.layoutManager = LinearLayoutManager(this)
        countryAdapter= CountryAdapter(this)
        countryRecycleView.adapter=countryAdapter
    }

    private fun initRecycleView() {
            val countryViewModel:CountryViewModel=ViewModelProvider(this).get(CountryViewModel::class.java)
                countryViewModel.getLiveDataObserver().observe(this, Observer {
                    if(it!=null){
                        countryAdapter.setCountryList(it)
                        countryAdapter.notifyDataSetChanged()
                    }else
                        Toast.makeText(this,"No DataAvaliable",Toast.LENGTH_SHORT).show()
                })
        countryViewModel.makeApiCall()
    }

}