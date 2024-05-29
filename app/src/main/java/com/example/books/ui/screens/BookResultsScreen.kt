package com.example.books.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.books.R
import com.example.books.model.Book
import com.example.books.ui.components.BookCard
import com.example.books.ui.components.Illustration
import com.example.books.ui.components.SearchTextField

@Composable
fun BookResultsScreen(
    books: List<Book>,
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

    Column(modifier = modifier) {
        SearchTextField(
            input = input,
            maxNumberOfCharacters = maxNumberOfChars,
            onValueChange = { if (it.matches(pattern)) input = it },
            onDone = { onDone() },
            modifier = Modifier.fillMaxWidth()
        )
        BookResultsList(books = books)
    }
}

@Composable
private fun BookResultsList(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    if (books.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(4.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            items(
                items = books,
                key = { book -> book.id },
            ) { book ->
                book.logBookData()
                BookCard(book = book)
            }
        }
    } else {
        Illustration(
            illustration = R.drawable.undraw_void__3_ggu,
            optionalText = R.string.no_results,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun NoResultsFound() {
    BookResultsScreen(books = listOf(), getBooksByQuery = {})
}