package com.stephanieverissimo.aluvery.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.stephanieverissimo.aluvery.R
import com.stephanieverissimo.aluvery.extensions.toBrazilianCurrency
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.sampleData.sampleProducts
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
) {
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(elevation),
    ) {
        Column(modifier) {
            AsyncImage(model = product.image,
                       contentDescription = null,
                       modifier
                           .fillMaxWidth()
                           .height(100.dp),
                       placeholder = painterResource(id = R.drawable.placeholder),
                       contentScale = ContentScale.Crop)
            Column(modifier
                       .fillMaxWidth()
                       .background(MaterialTheme.colorScheme.primaryContainer)
                       .padding(16.dp)
            )
            {
                Text(text = product.name)
                Text(text = product.price.toBrazilianCurrency())
            } // TODO: adicionar descrição do produto
            // Text(
            //     text = product.description,
            //     Modifier
            //         .padding(16.dp)
            // )
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}