package com.stephanieverissimo.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephanieverissimo.aluvery.ui.theme.AluveryTheme

@Composable
fun SearchedText(
    searchedText: String = "",
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchedText,
        onValueChange = { newValue -> onSearchChange(newValue) },
        modifier,
        shape = RoundedCornerShape(100),
        label = {
            Text("Product")

        },
        placeholder = { Text(text = "What are you look for?") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "icon search"
            )
        })
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    AluveryTheme {
        Surface {
            SearchedText(
                searchedText = "",
                onSearchChange = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            SearchedText(
                searchedText = "a",
                onSearchChange = {},
            )
        }
    }
}