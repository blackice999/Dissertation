package com.dissertation.data.product.factory

import com.dissertation.data.product.generator.RandomNumberGenerator
import com.dissertation.data.product.specs.Specs
import com.dissertation.data.product.specs.TelephoneSpecs

class TelephoneFactory : BaseProductFactory() {

    override fun createBrandsList() = listOf("LG", "Panasonic", "Samsung", "Starlight")

    init {
        categoryId = TELEPHONE_CATEGORY_ID
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