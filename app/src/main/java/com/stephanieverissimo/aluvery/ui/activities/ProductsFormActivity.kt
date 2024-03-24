package com.stephanieverissimo.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

class ProductsFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Product Creation",
            Modifier
                .fillMaxWidth(),
            fontSize = 28.sp,
        )

        var url by remember {
            mutableStateOf("")
        }
        TextField(
            value = url, onValueChange = { url = it },
            Modifier
                .fillMaxWidth(),
            label = { Text("Url")}
        )


        var name by remember {
            mutableStateOf("")
        }
        TextField(
            value = name, onValueChange = { name = it },
            Modifier
                .fillMaxWidth(),
            label = { Text("Name")}
        )

        var price by remember {
            mutableStateOf("")
        }
        TextField(
            value = price, onValueChange = { price = it },
            Modifier
                .fillMaxWidth(),
            label = { Text("Price")}
        )

        var description by remember {
            mutableStateOf("")
        }
        TextField(
            value = description, onValueChange = { description = it },
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = { Text("Description")}
        )

        Button(onClick = { },
            Modifier
                .fillMaxWidth()) {
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