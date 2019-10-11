package com.dissertation.data.factory.product

import com.dissertation.model.product.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class ProductFactory {

    var products: List<Product> = runBlocking {
        createProductsList()
    }

    private suspend fun createProductsList() = withContext(Dispatchers.Default) {
        val products = mutableListOf<Product>()
        products.addAll(TVFactory().generate())
        products.addAll(WashingMachineFactory().generate())
        products.addAll(TelephoneFactory().generate())
        products
    }
}