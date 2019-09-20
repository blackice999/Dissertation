package com.dissertation.data.product.specs

data class TVSpecs(val resolution: String, val size: Double, val color: String) : Specs() {

    companion object {
        val validResolutions = listOf(Pair(1366, 768), Pair(1920, 1080), Pair(3840, 2160))
        val validSizes = listOf(32, 44, 50, 60)
        val validColors = listOf("white", "black", "grey")
    }
}