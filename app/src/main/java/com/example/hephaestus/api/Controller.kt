package com.example.hephaestus.api

import android.util.Log
import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Controller : Callback<SolMeta> {
    private val url = "https://api.nasa.gov/"
    private var callback: (()->Unit) = {}

    fun start(callback: (()->Unit)) {
        Log.e("zzz", "zzz start")
        val moshi: Moshi = Moshi.Builder()
            .add(SolMetaAdapter())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()

        this.callback = callback
        val insightApi: InsightApi = retrofit.create(InsightApi::class.java)
        val call = insightApi.loadChanges("juNRGzMRndO98bBRpZ8bw9pw6Wo4xnHZSe4bujSo", "json", "1.0")
        call.enqueue(this)
    }

    override fun onResponse(call: Call<SolMeta>, response: Response<SolMeta>) {
        val body = response.body()
        Log.e("zzz", "zzz onResponse")
        if (response.body()!!.solList.isNotEmpty()) {
            callback.invoke()
            response.isSuccessful
            for (solData in body?.solList.orEmpty()) {
                Log.e("zzz", "zzz response: " + solData.firstUtc)
            }
        }
    }

    override fun onFailure(call: Call<SolMeta>, t: Throwable) {
        Log.e("Controller", t.message)
    }

}