package com.dissertation.data.factory.product

import com.dissertation.model.product.ProductCategories
import com.dissertation.data.factory.generator.RandomNumberGenerator
import com.dissertation.model.product.specs.Specs
import com.dissertation.model.product.specs.WashingMachineSpecs

class WashingMachineFactory : BaseProductFactory() {
    override fun createBrandsList() = listOf("Indesit", "Samsung", "Whirlpool")

    init {
        categoryId = ProductCategories.WASHING_MACHINE
    }

    override fun createSpecs(): Specs = WashingMachineSpecs(
        RandomNumberGenerator.generate((600..1200 step 200)),
        RandomNumberGenerator.generate((1..7)),
        RandomNumberGenerator.generate((1..70)).toDouble()
    )
}