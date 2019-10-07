package com.dissertation.model.product

import com.dissertation.model.product.specs.Specs

open class Product(
    val categoryId: ProductCategories = ProductCategories.INVALID,
    val brand: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0,
    val reviews: List<Review> = arrayListOf(),
    val specs: Specs = Specs()
) {

    data class Builder(
        private var categoryId: ProductCategories = ProductCategories.INVALID,
        private var brand: String = "",
        private var price: Double = 0.0,
        private var quantity: Int = 0,
        private var reviews: List<Review> = arrayListOf(),
        private var specs: Specs = Specs()
    ) {
        fun categoryId(categoryId: ProductCategories) = apply { this.categoryId = categoryId }
        fun brand(brand: String) = apply { this.brand = brand }
        fun price(price: Double) = apply { this.price = price }
        fun quantity(quantity: Int) = apply { this.quantity = quantity }
        fun reviews(reviews: List<Review>) = apply { this.reviews = reviews }
        fun specs(specs: Specs) = apply { this.specs = specs }
        fun build() = Product(categoryId, brand, price, quantity, reviews, specs)
    }
}