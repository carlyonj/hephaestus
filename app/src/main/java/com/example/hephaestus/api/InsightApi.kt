package com.example.hephaestus.api

import com.example.hephaestus.models.SolMeta
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface InsightApi {
    @GET("insight_weather/")
    fun loadChanges(
        @Query("api_key")key: String,
        @Query("feedtype")json: String,
        @Query("ver")ver: String) : Call<SolMeta>
}