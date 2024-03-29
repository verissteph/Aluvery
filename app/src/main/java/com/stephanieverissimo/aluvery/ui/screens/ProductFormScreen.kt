package com.stephanieverissimo.aluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.stephanieverissimo.aluvery.R
import com.stephanieverissimo.aluvery.models.Product
import com.stephanieverissimo.aluvery.ui.states.ProductFormUiState
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme
import com.stephanieverissimo.aluvery.ui.viewmodels.ProductFormScreenViewModel
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.DecimalFormat


@Composable
fun ProductsFormScreen(
    viewModel: ProductFormScreenViewModel,
    onSaveClick: (Product) -> Unit = {},
) {
    val state by viewModel.uiState.collectAsState()
    ProductsFormScreen(state = state)
}

@Composable
fun ProductsFormScreen(state: ProductFormUiState = ProductFormUiState()) {
    val url = state.url
    val name = state.name
    val price = state.price
    val description = state.description


    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Product Creation",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )

        if (state.isShowPreview) {
            AsyncImage(
                model = url,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentDescription = "image of url",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),
            )
        }

        TextField(
            value = url, onValueChange = state.onUrlChange,
            Modifier
                .fillMaxWidth(),
            label = { Text("Url") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = name, onValueChange = state.onNameChange,
            Modifier
                .fillMaxWidth(),
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        TextField(
            value = price, onValueChange = state.onPriceChange,
            Modifier
                .fillMaxWidth(),
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = description, onValueChange = state.onDescriptionChange,
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = { Text("Description") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = state.onSaveClick,
            Modifier.fillMaxWidth(),
        ) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier)
    }

}

@Preview
@Composable
private fun ProductFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProductsFormScreen(state = ProductFormUiState())
        }
    }
}

@Preview
@Composable
private fun ProductFormScreenFilledPreview() {
    AluveryTheme {
        Surface {
            ProductsFormScreen(
                state = ProductFormUiState(
                    url = "url teste",
                    name = "nome teste",
                    price = "123",
                    description = "descrição teste"
                )
            )
        }
    }

}
