package com.example.hephaestus.api

import android.util.JsonReader
import android.util.Log
import com.example.hephaestus.models.SolData
import com.example.hephaestus.models.SolDataJsonAdapter
import com.example.hephaestus.models.SolMeta
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.NumberFormatException

class SolMetaAdapter {
//    @FromJson
//    fun fromJson(json: Map<String, Any>): SolMeta {
//        var moshi = Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .build()
//        var adapter = moshi.adapter<SolData>(SolData().javaClass).lenient()
//
//        var solMeta = SolMeta()
//        var solCount = 0;
//        json.entries.forEach {
//            val key = it.key
//            val value = it.value
//            val n = 5
//            Log.e("zzz", "zzz item key: " + it.key)
//            Log.e("zzz", "zzz item value: " + it.value.toString())
//            if (it.key.equals("sol_keys", true)) {
//                Log.e("zzz", "zzz item sol_key: " + it.key)
//                solMeta.sol_keys.remove(0)
//                (it.value as ArrayList<*>).forEach {
//                    var key = it as String
//                    solMeta.sol_keys.add(key.toInt())
//                }
//            }
//            if (isSol(it.key)) {
//                var test = it.value.toString()
//                Log.e("zzz", "zzz entry it to string: " + (it.toString().drop(4)))
//                Log.e("zzz", "zzz entry key: " + (it.key))
//                Log.e("zzz", "zzz entry value: " + test)
//                solMeta.solList[solCount] = adapter.fromJson(it.toString().drop(4))!!
//            }
//        }
//        return solMeta
//    }

    //A sol can probably have a value between 0 and 669 so anything between those can potentially be valid. this sucks
    private fun isSol(sol: String): Boolean {
        try {
            if (sol.toInt() >= 0 && sol.toInt() <= 669) return true
        } catch (e: NumberFormatException) {
            return false
        }
        return false
    }

    @FromJson
    fun fromJson(json: com.squareup.moshi.JsonReader): SolMeta {
        var moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        var adapter = moshi.adapter<SolData>(SolData().javaClass)

        var solMeta = SolMeta()
        var solCount = 0;

        Log.e("zzz", "zzz json " + json.toString())
        json.beginObject()
        while (json.hasNext()) {
            val name = json.nextName()
            if (name.equals("sol_keys") || name.equals("validity_checks")) {
                json.skipValue()
                continue;
            }
            if (isSol(name)) {
                var solDetail = adapter.fromJson(json)!!
                solMeta.solList[solCount++] = solDetail
            } else {
                json.skipName()
            }
        }
        json.endObject()

        return solMeta
    }
}