package com.stephanieverissimo.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.stephanieverissimo.aluvery.dao.ProductDao
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProductCandies
import com.stephanieverissimo.aluvery.sampleData.sampleProductDrinks
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import com.stephanieverissimo.aluvery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = mapOf(
                "All products" to dao.products(),
                "Promotions" to sampleProductDrinks + sampleProductCandies,
                "Candies" to sampleProductCandies,
                "Drinks" to sampleProductDrinks
            ),
            onSearchChange = {newValue ->
                uiState = uiState.copy(
                    searchText = newValue,
                    searchedProducts = searchedProducts(newValue)
                )
            }
        )
    )
        private set
    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }
   private fun searchedProducts(text: String): List<Product> {
       return  if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    dao.products().filter(containsInNameOrDescription(text))
        } else emptyList()
    }

}