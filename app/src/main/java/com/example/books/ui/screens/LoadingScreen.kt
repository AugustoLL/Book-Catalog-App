package com.example.books.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.books.R
import com.example.books.ui.components.Illustration

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Illustration(
            illustration = R.drawable.undraw_loading_re_5axr,
            optionalText = R.string.loading,
            modifier = Modifier.fillMaxSize()
        )
    }
}