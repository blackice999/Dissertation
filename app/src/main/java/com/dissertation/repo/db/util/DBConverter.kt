package com.dissertation.repo.db.util

import com.dissertation.data.converter.JSONConverter
import com.dissertation.model.product.Product
import com.dissertation.model.product.ProductCategories
import com.dissertation.model.product.Review
import com.dissertation.model.product.specs.Specs
import com.dissertation.model.product.specs.TVSpecs
import com.dissertation.model.product.specs.TelephoneSpecs
import com.dissertation.model.product.specs.WashingMachineSpecs
import com.dissertation.repo.db.AppDatabase
import com.dissertation.repo.db.entities.ProductEntity
import com.dissertation.repo.db.entities.ReviewEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DBConverter(val db: AppDatabase) {
    private val jsonConverter = JSONConverter()

    fun convertProductToDBEntity(product: Product): ProductEntity {
        val productEntity = ProductEntity()
        with(product) {
            productEntity.categoryId = categoryId.name
            productEntity.brand = brand
            productEntity.price = price
            productEntity.quantity = quantity
            productEntity.specs = convertToJson(product.categoryId, product.specs)
        }
        return productEntity
    }

    private fun convertToJson(categoryId: ProductCategories, specs: Specs): String {
        val jsonConverter = JSONConverter()
        return when (categoryId) {
            ProductCategories.TV -> jsonConverter.toJsonString(specs as TVSpecs)
            ProductCategories.TELEPHONE -> jsonConverter.toJsonString(specs as TelephoneSpecs)
            ProductCategories.WASHING_MACHINE -> jsonConverter.toJsonString(specs as WashingMachineSpecs)
            else -> throw java.lang.IllegalStateException("Invalid specs")
        }
    }

    suspend fun convertProductEntityToProduct(productEntity: ProductEntity): Product {
        return Product(
            ProductCategories.valueOf(productEntity.categoryId),
            productEntity.brand,
            productEntity.price,
            productEntity.quantity,
            getReviewsForProduct(productEntity.id ?: 0),
            getSpecs(ProductCategories.valueOf(productEntity.categoryId), productEntity.specs)!!
        )
    }

    private fun getSpecs(categoryId: ProductCategories, specs: String) = when (categoryId) {
        ProductCategories.TV -> jsonConverter.fromJsonString<TVSpecs>(
            specs
        )
        ProductCategories.TELEPHONE -> jsonConverter.fromJsonString<TelephoneSpecs>(
            specs
        )
        ProductCategories.WASHING_MACHINE -> jsonConverter.fromJsonString<WashingMachineSpecs>(
            specs
        )
        else -> throw IllegalStateException("Invalid product category id")
    }

    private suspend fun getReviewsForProduct(productId: Int): List<Review> {
        return withContext(Dispatchers.Default) {
            val reviewsForProduct = db.reviewDao().getReviewsForProduct(productId)

            val reviews = mutableListOf<Review>()
            reviewsForProduct.forEach {
                reviews.add(Review(it.comment, it.rating))
            }
            reviews
        }
    }

    fun convertReviewToDBEntity(review: Review, productId: Long): ReviewEntity {
        val reviewEntity = ReviewEntity()
        with(review) {
            reviewEntity.productId = productId
            reviewEntity.comment = comment
            reviewEntity.rating = rating
        }

        return reviewEntity
    }
}