package com.stephanieverissimo.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stephanieverissimo.aluvery.R
import com.stephanieverissimo.aluvery.ui.theme.Purple40
import com.stephanieverissimo.aluvery.ui.theme.Purple80
import com.stephanieverissimo.aluvery.ui.theme.Teal200



@Composable
fun ProductItemDescription(description: String = "") {
    Surface(
        modifier = Modifier.shadow(elevation = 4.dp),
        shape = RoundedCornerShape(15.dp),
        
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            if (description.isNotBlank()) {
                Text(
                    text = description,
                    Modifier
                        .background(Color.Blue)
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                            top = 8.dp
                        ),
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItem() {
    Surface(Modifier
                .clip(RoundedCornerShape(15.dp))
                .shadow(elevation = 4.dp)
    
    ) {
        Column(Modifier
                   .width(200.dp)
                   .heightIn(250.dp, 300.dp)) {
            val imageHeight = 100.dp
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(listOf(Purple40, Teal200)))
                .height(imageHeight)) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                      contentDescription = "Image product item",
                      Modifier
                          .align(Alignment.BottomCenter)
                          .offset(y = imageHeight / 2)
                          .size(imageHeight)
                          .clip(CircleShape)
                
                )
            }
            Spacer(modifier = Modifier.height(imageHeight / 2))
            Column(Modifier.padding(16.dp)) {
                Text(text = LoremIpsum().values.first(),
                     maxLines = 2,
                     fontWeight = FontWeight(700),
                     fontSize = 18.sp,
                     overflow = TextOverflow.Ellipsis)
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    
                    )
            }
            
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun NewProductItem() {
    Surface(Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(15.dp))
                .shadow(elevation = 8.dp)
    
    ) {
        Row(Modifier
                .fillMaxWidth()
                .height(150.dp)) {
            Box(modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
                .background(brush = Brush.verticalGradient(listOf(Purple40, Teal200))))
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                  contentDescription = "image new product item",
                  Modifier
                      .size(100.dp)
                      .offset(x = (- 50).dp)
                      .border(width = 4.dp,
                              brush = Brush.verticalGradient(listOf(Purple80, Teal200)),
                              shape = CircleShape)
                      .clip(CircleShape)
                      .align(Alignment.CenterVertically))
            
            Text(text = LoremIpsum().values.first(),
                 modifier = Modifier
                     .align(Alignment.CenterVertically)
                     .padding(end = 8.dp),
                 fontSize = 14.sp,
                 fontWeight = FontWeight(700),
                 overflow = TextOverflow.Ellipsis,
                 maxLines = 6,
                 lineHeight = TextUnit(20F, TextUnitType.Sp))
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSections() {
    Column {
        Text(text = "Promoções",
             modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
             fontSize = 20.sp,
             fontWeight = FontWeight(400))
        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            
            ) {
            ProductItem()
            ProductItem()
            ProductItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemDescriptionPreview() {
    ProductItemDescription(LoremIpsum(50).values.first())
}

@Preview(showBackground = true)
@Composable
fun ProductItemDescriptionWithoutDescriptionPreview() {
    ProductItemDescription()
}