package com.stephanieverissimo.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

class ProductsFormActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AluveryTheme {
                Surface {
                   ProductsFormScreen()
                }
            }
        }
    }
}

@Composable
fun ProductsFormScreen() {
    Column {
        Text(text = "Product Creation")

        var url by remember {
            mutableStateOf("")
        }
        TextField(value = url, onValueChange = { url = it})


        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = { name = it})

        var price by remember {
            mutableStateOf("")
        }
        TextField(value = price, onValueChange = { price = it})

        var description by remember {
            mutableStateOf("")
        }
        TextField(value = description, onValueChange = { description = it})

        Button(onClick = {  }) {
            Text(text = "Save")
            
        }
    }
}

@Preview
@Composable
private fun ProductsFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProductsFormScreen()
        }
    }
}