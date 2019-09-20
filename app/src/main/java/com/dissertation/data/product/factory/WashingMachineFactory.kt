package com.dissertation.data.product.factory

import com.dissertation.data.product.generator.RandomNumberGenerator
import com.dissertation.data.product.specs.Specs
import com.dissertation.data.product.specs.WashingMachineSpecs

class WashingMachineFactory : BaseProductFactory() {
    override fun createBrandsList() = listOf("Indesit", "Samsung", "Whirlpool")

    init {
        categoryId = WASHING_MACHINE_CATEGORY_ID
    }

    override fun createSpecs(): Specs = WashingMachineSpecs(
        RandomNumberGenerator.generate((600..1200 step 200)),
        RandomNumberGenerator.generate((1..7)),
        RandomNumberGenerator.generate((1..70)).toDouble()
    )
}