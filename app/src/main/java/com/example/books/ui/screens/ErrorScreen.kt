package com.example.books.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.books.R
import com.example.books.ui.components.Illustration

@Composable
fun ErrorScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Illustration(
            illustration = R.drawable.undraw_server_down_s_4_lk,
            optionalText = R.string.error,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { onClick() },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = stringResource(R.string.retry_button))
        }
    }
}