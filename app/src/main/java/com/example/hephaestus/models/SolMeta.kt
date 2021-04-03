package com.example.hephaestus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SolMeta {
    var solKeys: MutableList<String> = mutableListOf()
    val solList: MutableList<SolData> = mutableListOf()
    @Transient
    val validity_checks = ""

}