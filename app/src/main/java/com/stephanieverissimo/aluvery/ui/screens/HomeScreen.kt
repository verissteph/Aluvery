package com.stephanieverissimo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephanieverissimo.aluvery.ui.components.CardProductItem
import com.stephanieverissimo.aluvery.ui.components.ProductSection
import com.stephanieverissimo.aluvery.ui.components.SearchedText
import com.stephanieverissimo.aluvery.sampleData.sampleSections
import com.stephanieverissimo.aluvery.ui.states.HomeScreenUiState
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme
import com.stephanieverissimo.aluvery.ui.viewmodels.HomeScreenViewModel


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel) {

     val state by viewModel.uiState.collectAsState()

    HomeScreen(state = state)

}
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {

    AluveryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val sections = state.sections
            val text = state.searchText
            val searchedProducts = state.searchedProducts
            Column {
                SearchedText(
                    searchedText = text,
                    onSearchChange = state.onSearchChange,
                    Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

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
                            CardProductItem(
                                product = p,
                            )
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
            HomeScreen(HomeScreenUiState(sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                HomeScreenUiState(

                    sampleSections, searchText = "a"
                )
            )
        }
    }
}