package com.dissertation.repo.db.util

import com.dissertation.data.converter.JSONConverter
import com.dissertation.model.product.Product
import com.dissertation.model.product.ProductCategories
import com.dissertation.model.product.Review
import com.dissertation.model.product.specs.Specs
import com.dissertation.model.product.specs.TVSpecs
import com.dissertation.model.product.specs.TelephoneSpecs
import com.dissertation.model.product.specs.WashingMachineSpecs
import com.dissertation.repo.db.entities.ProductEntity
import com.dissertation.repo.db.entities.ReviewEntity

class DBConverter(val jsonConverter: JSONConverter) {

    fun productToDBEntity(product: Product): ProductEntity {
        val productEntity = ProductEntity()
        with(product) {
            productEntity.categoryId = categoryId.name
            productEntity.brand = brand
            productEntity.price = price
            productEntity.quantity = quantity
            productEntity.specs = specsToJson(product.categoryId, product.specs)
        }

        return productEntity
    }

    fun productEntityToProduct(productEntity: ProductEntity, reviews: List<Review>) = Product(
        ProductCategories.valueOf(productEntity.categoryId),
        productEntity.brand,
        productEntity.price,
        productEntity.quantity,
        reviews,
        specsFromJson(ProductCategories.valueOf(productEntity.categoryId), productEntity.specs)!!
    )

    fun reviewToDBEntity(review: Review, productId: Long): ReviewEntity {
        val reviewEntity = ReviewEntity()
        with(review) {
            reviewEntity.productId = productId
            reviewEntity.comment = comment
            reviewEntity.rating = rating
        }

        return reviewEntity
    }

    fun reviewEntityToReview(reviewEntity: ReviewEntity) = Review(reviewEntity.comment, reviewEntity.rating)

    private fun specsToJson(categoryId: ProductCategories, specs: Specs) = when (categoryId) {
        ProductCategories.TV -> jsonConverter.toJsonString(specs as TVSpecs)
        ProductCategories.TELEPHONE -> jsonConverter.toJsonString(specs as TelephoneSpecs)
        ProductCategories.WASHING_MACHINE -> jsonConverter.toJsonString(specs as WashingMachineSpecs)
        else -> throw java.lang.IllegalStateException("Invalid specs")
    }

    private fun specsFromJson(categoryId: ProductCategories, specs: String) = when (categoryId) {
        ProductCategories.TV -> jsonConverter.fromJsonString<TVSpecs>(specs)
        ProductCategories.TELEPHONE -> jsonConverter.fromJsonString<TelephoneSpecs>(specs)
        ProductCategories.WASHING_MACHINE -> jsonConverter.fromJsonString<WashingMachineSpecs>(specs)
        else -> throw IllegalStateException("Invalid product category id")
    }
}