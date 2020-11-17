package com.example.hephaestus.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SolData {
    @field:Json(name = "AT")
    public var temperature = DataDetail()
    @field:Json(name = "First_UTC")
    public var firstUtc = ""
    @field:Json(name = "HWS")
    public var windSpeed = DataDetail()
    @field:Json(name = "PRE")
    public var pressure = DataDetail()
    @field:Json(name = "Season")
    public var season = ""
    @field:Json(name = "Last_UTC")
    public var lastUtc = ""
    @Transient
    @field:Json(name ="WD")
    public var windDirection = ""

}