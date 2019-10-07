package com.dissertation.data.factory.product

import com.dissertation.data.factory.generator.RandomNumberGenerator
import com.dissertation.model.product.Product
import com.dissertation.model.product.ProductCategories
import com.dissertation.model.product.Review
import com.dissertation.model.product.specs.Specs

abstract class BaseProductFactory {
    protected var categoryId = ProductCategories.INVALID

    protected abstract fun createSpecs(): Specs
    protected abstract fun createBrandsList(): List<String>

    private fun createReviewsList(): List<Review> {
        val reviews = mutableListOf<Review>()
        (0 until RandomNumberGenerator.generate((0..MAX_REVIEWS_NUMBER))).asSequence()
            .forEach {
                reviews.add(
                    Review(
                        "Comment $it",
                        RandomNumberGenerator.generate((1..5))
                    )
                )
            }

        return reviews
    }

    fun generate(): List<Product> {
        val productList = mutableListOf<Product>()
        val brands = createBrandsList()

        (0 until MAX_PRODUCTS_NUMBER).asSequence().forEach { _ ->
            productList.add(
                Product.Builder()
                    .categoryId(categoryId)
                    .brand(brands.random())
                    .price(createPrice())
                    .quantity(createQuantity())
                    .reviews(createReviewsList())
                    .specs(createSpecs())
                    .build()
            )
        }

        return productList
    }

    private fun createQuantity() = RandomNumberGenerator.generate((0 until MAX_QUANTITY))

    private fun createPrice() =
        RandomNumberGenerator.generate((0 until MAX_PRICE)).toDouble()

    companion object {
        private const val MAX_PRODUCTS_NUMBER = 10
        private const val MAX_REVIEWS_NUMBER = 50
        private const val MAX_PRICE = 1000
        private const val MAX_QUANTITY = 5000

        fun getTotalProductsCount() = ProductCategories.values().filter { it != ProductCategories.INVALID }.size * MAX_PRODUCTS_NUMBER
    }
}