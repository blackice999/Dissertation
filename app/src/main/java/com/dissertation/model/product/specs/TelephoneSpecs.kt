package com.dissertation.model.product.specs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TelephoneSpecs(
    val os: String,
    @Json(name = "ram_size") val ramSize: Int,
    @Json(name = "battery_capacity") val batteryCapacity: Int,
    val weight: Int,
    val resolution: String
) : Specs() {

    companion object {
        val validResolutions = listOf(Pair(1920, 1080), Pair(480, 640), Pair(720, 1280))
        val validOSs = listOf("Android", "iOS")
    }
}