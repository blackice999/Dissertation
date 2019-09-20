package com.dissertation.data.product.specs

data class TelephoneSpecs(
    val os: String,
    val ramSize: Int,
    val batteryCapacity: Int,
    val weight: Int,
    val resolution: String
) : Specs() {

    companion object {
        val validResolutions = listOf(Pair(1920, 1080), Pair(480, 640), Pair(720, 1280))
        val validOSs = listOf("Android", "iOS")
    }
}