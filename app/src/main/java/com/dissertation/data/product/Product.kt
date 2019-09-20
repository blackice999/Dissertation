package com.dissertation.data.product

import com.dissertation.data.product.specs.Specs

open class Product(
    val categoryId: Int? = null,
    val brand: String? = null,
    val price: Double? = 0.0,
    val quantity: Int? = 0,
    val reviews: List<Int> = arrayListOf(),
    val comments: List<String> = arrayListOf(),
    val specs: Specs? = null
) {

    data class Builder(
        private var categoryId: Int? = null,
        private var brand: String? = null,
        private var price: Double? = null,
        private var quantity: Int? = null,
        private var reviews: List<Int> = arrayListOf(),
        private var comments: List<String> = arrayListOf(),
        private var specs: Specs? = null
    ) {
        fun categoryId(categoryId: Int) = apply { this.categoryId = categoryId }
        fun brand(brand: String) = apply { this.brand = brand }
        fun price(price: Double) = apply { this.price = price }
        fun quantity(quantity: Int) = apply { this.quantity = quantity }
        fun reviews(reviews: List<Int>) = apply { this.reviews = reviews }
        fun comments(comments: List<String>) = apply { this.comments = comments }
        fun specs(specs: Specs) = apply { this.specs = specs }
        fun build() = Product(categoryId, brand, price, quantity, reviews, comments, specs)
    }
}