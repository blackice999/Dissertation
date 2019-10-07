package com.dissertation.model.product

import com.dissertation.repo.product.ProductRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductModel(val productRepo: ProductRepo) {
    suspend fun getProductsCount(): Int {
        return productRepo.getProductsCount()
    }

    suspend fun getProducts() = withContext(Dispatchers.Default) {
        productRepo.getProducts()
    }

    suspend fun init() = productRepo.init()
}