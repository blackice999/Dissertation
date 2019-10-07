package com.dissertation.repo.product

import com.dissertation.model.product.Product
import com.dissertation.repo.db.AppDatabase
import com.dissertation.repo.db.dao.ProductDao
import com.dissertation.repo.db.util.DBConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class ProductRepoImpl(val productDao: ProductDao, val dbConverter: DBConverter) : ProductRepo, KoinComponent {

    val db: AppDatabase by inject()

    override suspend fun init(): Boolean = db.prepopulateDB(dbConverter)

    override suspend fun getProducts() = withContext(Dispatchers.Default) {
        val products = mutableListOf<Product>()
        productDao.getProducts().map {
            products.add(dbConverter.convertProductEntityToProduct(it))
        }

        products
    }

    override suspend fun getProductsCount() = productDao.count()
}