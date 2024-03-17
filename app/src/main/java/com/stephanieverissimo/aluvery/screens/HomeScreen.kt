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
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import com.stephanieverissimo.aluvery.sampleData.sampleSections
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {
    var text by remember { mutableStateOf("") }
    AluveryTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column {
                OutlinedTextField(value = text,
                                  onValueChange = { newValue -> text = newValue },
                                  modifier = Modifier
                                      .padding(16.dp)
                                      .fillMaxWidth(),
                                  shape = RoundedCornerShape(100),
                                  label = {
                                      Text("Search")
                                      
                                  },
                                  placeholder = { Text(text = "What are you look for?") },
                                  leadingIcon = {
                                      Icon(imageVector = Icons.Default.Search,
                                           contentDescription = "icon search")
                                  })
                LazyColumn(Modifier.fillMaxSize().padding(16.dp),
                           verticalArrangement = Arrangement.spacedBy(16.dp),
                           contentPadding = PaddingValues(bottom = 16.dp)) {
                    items(sampleProducts) { product ->
                        CardProductItem(
                            product = product)
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