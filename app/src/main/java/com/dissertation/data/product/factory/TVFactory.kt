package com.dissertation.data.product.factory

import com.dissertation.data.product.specs.Specs
import com.dissertation.data.product.specs.TVSpecs

class TVFactory : BaseProductFactory() {
    override fun createBrandsList() = listOf("LG", "Panasonic", "Samsung", "Starlight")

    init {
        categoryId = TV_CATEGORY_ID
    }

    override fun createSpecs(): Specs {
        val resolution = TVSpecs.validResolutions.random()
        return TVSpecs(
            "${resolution.first} x ${resolution.second}",
            TVSpecs.validSizes.random().toDouble(),
            TVSpecs.validColors.random()
        )
    }
}