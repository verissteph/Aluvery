package com.stephanieverissimo.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephanieverissimo.aluvery.components.ProductSection
import com.stephanieverissimo.aluvery.sampleData.sampleProductCandies
import com.stephanieverissimo.aluvery.sampleData.sampleProductCombo
import com.stephanieverissimo.aluvery.sampleData.sampleProductDrinks
import com.stephanieverissimo.aluvery.sampleData.sampleProductPromo
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    AluveryTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
                   verticalArrangement = Arrangement.spacedBy(16.dp)
            
            ) {
                Spacer(modifier = Modifier)
                ProductSection("Promotions", sampleProductPromo)
                ProductSection("Combos", sampleProductCombo)
                ProductSection("Candies", sampleProductCandies)
                ProductSection("Drinks", sampleProductDrinks)
                Spacer(modifier = Modifier)
            }
            
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}