package com.example.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Retrofit.RetroInstance
import com.example.Retrofit.RetroServiceInterface
import com.example.data.Countries
import retrofit2.*

class CountryViewModel : ViewModel() {
    var liveDatauserList = MutableLiveData<List<Countries>>()

    fun getLiveDataObserver(): MutableLiveData<List<Countries>> {
        return liveDatauserList
    }

    fun makeApiCall() {
        val restroInstance: Retrofit = RetroInstance.getRetroInstance()
        val retroService = restroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getListOfData()
        call.enqueue(object : Callback<List<Countries>?> {
            override fun onResponse(call: Call<List<Countries>?>, response: Response<List<Countries>?>) {
                    liveDatauserList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Countries>?>, t: Throwable) {
                liveDatauserList.postValue(null)
            }
        })
    }
}