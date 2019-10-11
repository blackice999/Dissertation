package com.dissertation.data.factory.product

import com.dissertation.model.product.ProductCategories
import com.dissertation.model.product.specs.Specs
import com.dissertation.model.product.specs.TVSpecs

class TVFactory : BaseProductFactory() {
    override fun createBrandsList() = listOf("LG", "Panasonic", "Samsung", "Starlight")

    init {
        categoryId = ProductCategories.TV
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