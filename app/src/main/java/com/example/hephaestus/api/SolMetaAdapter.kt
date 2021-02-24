package com.example.hephaestus.api

import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SolMetaAdapter {
    @FromJson
    fun fromJson(json: com.squareup.moshi.JsonReader): SolMeta {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter<SolData>(SolData().javaClass)

        val solMeta = SolMeta()

        json.beginObject()
        var solCount = 0
        while (json.hasNext()) {
            val name = json.nextName()
            if (name.equals("sol_keys") || name.equals("validity_checks")) {
                json.skipValue()
                continue;
            }
            if (isSol(name)) {
                val solDetail = adapter.fromJson(json)!!
                solMeta.solList[solCount++] = solDetail
            } else {
                json.skipName()
            }
        }
        json.endObject()

        return solMeta
    }

    //A sol can probably have a value between 0 and 900 so anything between those can potentially be valid. this sucks
    private fun isSol(sol: String): Boolean {
        try {
            if (sol.toInt() in 0..9000) return true
        } catch (e: NumberFormatException) {
            return false
        }
        return false
    }
}