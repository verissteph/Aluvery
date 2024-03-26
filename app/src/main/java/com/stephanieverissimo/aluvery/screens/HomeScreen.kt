package com.stephanieverissimo.aluvery.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephanieverissimo.aluvery.components.CardProductItem
import com.stephanieverissimo.aluvery.components.ProductSection
import com.stephanieverissimo.aluvery.components.SearchedText
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import com.stephanieverissimo.aluvery.sampleData.sampleSections
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

class HomeScreenUiState(private val searchedText: String = "") {
    var text by mutableStateOf(searchedText)

    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                            product.description?.contains(
                                text,
                                ignoreCase = true,
                            ) ?: false
                }
            } else emptyList()

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

}

@Composable
fun HomeScreen(
    sections: Map<String,
            List<Product>>,
    searchedText: String = ""
) {
    AluveryTheme {
        val state = remember {
            HomeScreenUiState(searchedText)
        }
        val text = state.text
        val searchedProducts = remember(text) {
            state.searchedProducts
        }
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column {
                SearchedText(
                    searchedText = text,
                    onSearchChange = { state.text = it },
                    Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

            }
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                if (state.isShowSections()) {
                    for (section in sections) {
                        val title = section.key
                        val products = section.value
                        item {
                            ProductSection(title = title, products = products)
                        }
                    }
                } else {
                    items(searchedProducts) { p ->
                        CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
        }

    }
}
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sampleSections,
                searchedText = "a",
            )
        }
    }
}