package com.stephanieverissimo.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ProductDao {

    companion object {
        val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products() = products.asStateFlow()

    fun save(product: Product) {
        products.value = products().value + product
    }

}