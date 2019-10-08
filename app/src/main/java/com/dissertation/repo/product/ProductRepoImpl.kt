package com.dissertation.repo.product

import com.dissertation.data.factory.product.ProductFactory
import com.dissertation.model.product.Product
import com.dissertation.model.product.Review
import com.dissertation.repo.db.dao.ProductDao
import com.dissertation.repo.db.dao.ReviewDao
import com.dissertation.repo.db.util.DBConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepoImpl(
    val productDao: ProductDao,
    val reviewDao: ReviewDao,
    val dbConverter: DBConverter
) : ProductRepo {

    override suspend fun init(): Boolean = prepopulateDB(dbConverter)

    override suspend fun getProducts() = withContext(Dispatchers.Default) {
        val products = mutableListOf<Product>()
        productDao.getProducts().map {
            products.add(dbConverter.productEntityToProduct(it, getReviewsForProduct(it.id!!)))
        }

        products
    }

    override suspend fun getProductsCount() = productDao.count()

    private suspend fun prepopulateDB(dbConverter: DBConverter) = withContext(Dispatchers.Default) {
        if (productDao.count() == 0) {
            ProductFactory().products.forEach { product ->
                val productId = productDao.insert(dbConverter.productToDBEntity(product))

                product.reviews.forEach {
                    reviewDao.insert(dbConverter.reviewToDBEntity(it, productId))
                }
            }
        }

        true
    }

    private suspend fun getReviewsForProduct(productId: Int) = withContext(Dispatchers.Default) {
        val reviews = mutableListOf<Review>()
        reviewDao.getReviewsForProduct(productId).forEach {
            reviews.add(dbConverter.reviewEntityToReview(it))
        }

        reviews
    }
}