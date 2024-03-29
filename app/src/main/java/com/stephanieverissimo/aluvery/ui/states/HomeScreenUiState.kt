package com.stephanieverissimo.aluvery.ui.states

import com.stephanieverissimo.aluvery.models.Product

data class HomeScreenUiState(
    val sections: Map<String,List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
){

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }

}
