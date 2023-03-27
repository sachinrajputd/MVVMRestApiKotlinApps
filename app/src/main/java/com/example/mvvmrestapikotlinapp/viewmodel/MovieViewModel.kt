package com.example.mvvmrestapikotlinapp.viewmodel

import android.os.Handler.Callback
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmrestapikotlinapp.dataclass.Movies
import com.example.mvvmrestapikotlinapp.dataclass.Result
import com.example.mvvmrestapikotlinapp.retrofit_instance.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

//Since we are using MVVM architecture we need to create a View Model Class with live-data in it.

class MovieViewModel: ViewModel() {
    private var movieLiveData= MutableLiveData<List<Result>>()

    fun getPopularMovie(){
        RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
            .enqueue(object : retrofit2.Callback<Movies> {
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {

                    if(response.body()!= null){

                        movieLiveData.value=response.body()!!.result
                    }else{
                        return
                    }

                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.d("TAG",t.message.toString())
                }


            })
    }
    fun observeLiveData(): LiveData<List<Result>>{

        return movieLiveData
    }
}