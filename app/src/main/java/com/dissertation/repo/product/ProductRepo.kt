package com.dissertation.repo.product

import com.dissertation.model.product.Product

interface ProductRepo {
    suspend fun getProducts(): List<Product>
    suspend fun getProductsCount(): Int
    suspend fun init(): Boolean
}