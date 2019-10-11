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

    override suspend fun init(): Boolean = prepopulateDB()

    override suspend fun getProducts() = withContext(Dispatchers.Default) {
        val products = mutableListOf<Product>()
        productDao.getProducts().map {
            products.add(dbConverter.productEntityToProduct(it, getReviewsForProduct(it.id!!)))
        }

        products
    }

    override suspend fun getProductsCount() = productDao.count()

    private suspend fun prepopulateDB() = withContext(Dispatchers.Default) {
        if (productDao.count() == 0) {
            val products = ProductFactory().products

            val productEntities = products.map {
                dbConverter.productToDBEntity(it)
            }

            val insertIds = productDao.insertAll(productEntities)
            insertIds.forEachIndexed { index, insertId ->
                val productReviews = products[index].reviews
                val reviewEntities = productReviews.map {
                    dbConverter.reviewToDBEntity(it, insertId)
                }

                reviewDao.insertAll(reviewEntities)
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