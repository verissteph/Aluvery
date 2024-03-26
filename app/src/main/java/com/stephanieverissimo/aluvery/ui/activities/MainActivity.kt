package com.stephanieverissimo.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stephanieverissimo.aluvery.dao.ProductDao
import com.stephanieverissimo.aluvery.sampleData.sampleProductCandies
import com.stephanieverissimo.aluvery.sampleData.sampleProductDrinks
import com.stephanieverissimo.aluvery.sampleData.sampleSections
import com.stephanieverissimo.aluvery.screens.HomeScreen
import com.stephanieverissimo.aluvery.screens.HomeScreenUiState
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    private val dao = ProductDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          App(onFabClick = {
              startActivity(Intent(
                  this,
                  ProductsFormActivity::class.java
              ))
          }){
              val sections = mapOf(
                  "All products" to dao.products,
                  "Promotions" to sampleProductDrinks + sampleProductCandies,
                  "Candies" to sampleProductCandies,
                  "Drinks" to sampleProductDrinks
              )
              val state = remember {
                  HomeScreenUiState()
              }
              HomeScreen(sections = sections, state)
          }
        }
    }
}

@Composable
fun App(onFabClick: () -> Unit = {}, content: @Composable ()->Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }

            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                   content()
                }
            }

        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App(){
        HomeScreen(sections = sampleSections)
    }

}