package com.dissertation.model.product.specs

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WashingMachineSpecs(
    val rotations: Int,
    val capacity: Int,
    @Json(name = "water_usage") val waterUsage: Double
) : Specs()