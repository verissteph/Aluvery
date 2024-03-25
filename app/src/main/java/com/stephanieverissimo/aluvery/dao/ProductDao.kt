package com.stephanieverissimo.aluvery.dao

import com.stephanieverissimo.aluvery.sampleData.sampleProducts

class ProductDao {
    companion object {
        val products = sampleProducts.toMutableList()
    }
    fun products() = products.toList()
}