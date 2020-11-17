package com.example.hephaestus.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SolMeta {
    val solList: Array<SolData> = Array(7) {
        SolData()
    }
    @Transient
    var sol_keys = mutableListOf(0)
    @Transient
    val validity_checks = ""

}