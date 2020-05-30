package com.example.hephaestus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*
import kotlin.collections.ArrayList

@JsonClass(generateAdapter = true)
class SolMeta {
    val solList: Array<SolData> = Array(7) {
        SolData()
    }
   // @field:Json(name = "523")
    var firstSol: SolData = SolData()
   // @field:Json(name = "524")
    var secondSol: SolData = SolData()
   // @field:Json(name = "525")
    var thirdSol: SolData = SolData()
   // @field:Json(name = "526")
    var fourthSol: SolData = SolData()
    //@field:Json(name = "527")
    var fifthSol: SolData = SolData()
   // @field:Json(name = "528")
    var sixthSol: SolData = SolData()
   // @field:Json(name = "529")
    var seventhSol: SolData = SolData()
    @Transient
    var sol_keys = mutableListOf(0)
    @Transient
    val validity_checks = ""

}