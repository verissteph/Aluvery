package com.stephanieverissimo.aluvery.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stephanieverissimo.aluvery.R
import com.stephanieverissimo.aluvery.extensions.toBrazilianCurrency
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme
import com.stephanieverissimo.aluvery.ui.theme.Purple40
import com.stephanieverissimo.aluvery.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
    Surface(Modifier
                .clip(RoundedCornerShape(15.dp))
                .shadow(elevation = 8.dp)
    
    ) {
        
        Column(Modifier
                   .width(200.dp)
                   .heightIn(250.dp, 300.dp)) {
            val imageHeight = 100.dp
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary,
                )))
                .height(imageHeight)) {
                Image(
                    //TODO: Adjust product image
                    painter = painterResource(id = R.drawable.placeholder),
                      contentDescription = "Image product item",
                      contentScale = ContentScale.Crop,
                      modifier = Modifier
                          .align(Alignment.BottomCenter)
                          .offset(y = imageHeight / 2)
                          .size(imageHeight)
                          .clip(CircleShape)
                
                )
            }
            Spacer(modifier = Modifier.height(imageHeight / 2))
            Column(Modifier.padding(16.dp)) {
                Text(text = product.name,
                     maxLines = 2,
                     fontWeight = FontWeight(700),
                     fontSize = 18.sp,
                     overflow = TextOverflow.Ellipsis)
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    
                    )
            }
            
        }
    }
    
}


@Preview(showSystemUi = true)
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                Product(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal("14.99")
                )
            )
        }
    }
}