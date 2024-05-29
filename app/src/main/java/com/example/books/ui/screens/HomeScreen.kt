package com.example.books.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)
) {
    when (
        val booksUiState = viewModel.booksUiState.collectAsStateWithLifecycle().value
    ) {
        is BooksUiState.Start ->
            StartScreen(getBooksByQuery = viewModel::getBooks)
        is BooksUiState.Success ->
            BookResultsScreen(
                getBooksByQuery = viewModel::getBooks,
                books = booksUiState.books
            )
        is BooksUiState.Loading ->
            LoadingScreen()
        is BooksUiState.Error ->
            ErrorScreen(onClick = { viewModel.resetState() }, modifier = Modifier.fillMaxSize())
    }
}