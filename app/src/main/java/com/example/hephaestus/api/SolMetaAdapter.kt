package com.example.hephaestus.api

import android.util.Log
import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolMeta
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

class SolMetaAdapter {
    @FromJson
    fun fromJson(json: com.squareup.moshi.JsonReader): SolMeta {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter<SolData>(SolData().javaClass)

        val solMeta = SolMeta()

        json.beginObject()
        while (json.hasNext()) {
            val name = json.nextName()
            if (name.equals("validity_checks")) {
                json.skipValue()
                continue
            }
            if (name.equals("sol_keys")) {
                json.beginArray()
                while (json.hasNext()) {
                    Log.e("zzz", "zzz  added key")
                    solMeta.solKeys.add(json.nextString())
                }
                json.endArray()
                continue
            }
            if (isSol(name)) {
                Log.e("zzz", "zzz  added sol " + name)
                val solDetail = adapter.fromJson(json)!!
                solDetail.sol = name
                solMeta.solList.add(solDetail)
            } else {
                json.skipName()
            }
        }
        json.endObject()
        removeInvalidSols(solMeta)
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

    private fun removeInvalidSols(solMeta: SolMeta)  {
            for (sol in solMeta.solList) {
                if (!solMeta.solKeys.contains(sol.sol) || sol.equals("invalid")) {
                    solMeta.solList.remove(sol)
            }
        }
    }
}
