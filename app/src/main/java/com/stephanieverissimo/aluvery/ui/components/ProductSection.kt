package com.stephanieverissimo.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductSection(title: String, products: List<Product>, modifier: Modifier = Modifier) {
    Column {
        Text(text = title,
             modifier = modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
             fontSize = 20.sp,
             fontWeight = FontWeight(400))
        LazyRow(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            
            ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    AluveryTheme {
        Surface {
            ProductSection("Promotions", products = sampleProducts)
        }
    }
}

