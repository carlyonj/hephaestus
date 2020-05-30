package com.example.hephaestus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DataDetail {
    @field:Json(name = "av")
    public var average = 00.00
    @field:Json(name = "ct")
    public var count = 00.00
    @field:Json(name = "mn")
    public var minimum = 00.00
    @field:Json(name = "mx")
    public var maximum = 00.00
}