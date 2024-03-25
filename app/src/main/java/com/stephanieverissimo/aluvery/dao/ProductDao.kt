package com.stephanieverissimo.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts


class ProductDao {

    companion object {
        val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }

}