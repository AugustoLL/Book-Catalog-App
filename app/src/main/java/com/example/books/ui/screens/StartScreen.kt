package com.example.books.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.books.R
import com.example.books.ui.components.SearchTextField

@Composable
fun StartScreen(
    getBooksByQuery: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var input by remember { mutableStateOf("") }
    val pattern = remember { Regex("[a-zA-z\\s]*") }
    val maxNumberOfChars = 120

    val onDone = {
        if (input.isNotEmpty()) {
            input = input.replace(" ", "+")
            getBooksByQuery(input)
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        SearchTextField(
            input = input,
            maxNumberOfCharacters = maxNumberOfChars,
            onValueChange = { if (it.matches(pattern)) input = it },
            onDone = onDone
        )
        Button(
            onClick = {onDone() },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.search_button))
        }
    }
}