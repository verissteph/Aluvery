package com.stephanieverissimo.aluvery.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephanieverissimo.aluvery.components.ProductSection
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleSections
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {
    AluveryTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            LazyColumn(modifier = Modifier.fillMaxSize(),
                       verticalArrangement = Arrangement.spacedBy(16.dp),
                       contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                
                for (section in sections) {
                    item() {
                        val title = section.key
                        val products = section.value
                        ProductSection(title = title, products = products)
                    }
                }
                
            }
            
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}