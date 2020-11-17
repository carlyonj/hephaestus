package com.example.hephaestus.api

import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SolMetaAdapter {
    @FromJson
    fun fromJson(json: com.squareup.moshi.JsonReader): SolMeta {
        var moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        var adapter = moshi.adapter<SolData>(SolData().javaClass)

        var solMeta = SolMeta()
        var solCount = 0;

        json.beginObject()
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

    //A sol can probably have a value between 0 and 669 so anything between those can potentially be valid. this sucks
    private fun isSol(sol: String): Boolean {
        try {
            if (sol.toInt() >= 0 && sol.toInt() <= 669) return true
        } catch (e: NumberFormatException) {
            return false
        }
        return false
    }
}