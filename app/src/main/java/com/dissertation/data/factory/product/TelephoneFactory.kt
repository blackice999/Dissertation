package com.dissertation.data.factory.product

import com.dissertation.model.product.ProductCategories
import com.dissertation.data.factory.generator.RandomNumberGenerator
import com.dissertation.model.product.specs.Specs
import com.dissertation.model.product.specs.TelephoneSpecs

class TelephoneFactory : BaseProductFactory() {

    override fun createBrandsList() = listOf("LG", "Panasonic", "Samsung", "Starlight")

    init {
        categoryId = ProductCategories.TELEPHONE
    }

    override fun createSpecs(): Specs {
        val resolution = TelephoneSpecs.validResolutions.random()
        return TelephoneSpecs(
            TelephoneSpecs.validOSs.random(),
            RandomNumberGenerator.generate((1..8)),
            RandomNumberGenerator.generate((1400..4000 step 100)),
            RandomNumberGenerator.generate((50..100 step 10)) + 140,
            "${resolution.first} x ${resolution.second}"
        )
    }
}