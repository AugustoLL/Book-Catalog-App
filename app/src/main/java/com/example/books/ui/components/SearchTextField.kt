package com.example.books.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.example.books.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    input: String,
    maxNumberOfCharacters: Int,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        isError = input.isEmpty(),
        value = input,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = stringResource(id = R.string.search_text_field),
                textAlign = TextAlign.Center
            )
        },
        singleLine = true,
        supportingText = {
            TextFieldSupportingText(
                inputLength = input.length,
                inputMaxLength = maxNumberOfCharacters,
                show = input != ""
            )
        }
    )
}

@Composable
private fun TextFieldSupportingText(
    inputLength: Int,
    inputMaxLength: Int,
    show: Boolean,
    modifier: Modifier = Modifier
) {
    if (show) {
        Text(
            text = "$inputLength / $inputMaxLength",
            textAlign = TextAlign.End,
            modifier = modifier.fillMaxWidth()
        )
    }
}