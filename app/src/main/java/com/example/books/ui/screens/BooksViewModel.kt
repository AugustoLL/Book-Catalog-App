package com.example.books.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.books.BooksApplication
import com.example.books.data.BooksRepository
import com.example.books.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BooksUiState {
    object Start: BooksUiState
    data class Success(val books: List<Book>): BooksUiState
    object Error: BooksUiState
    object Loading: BooksUiState
}

class BooksViewModel (
    private val booksRepository: BooksRepository
): ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    private val _booksUiState = MutableStateFlow<BooksUiState>(BooksUiState.Start)
    val booksUiState = _booksUiState.asStateFlow()

    fun getBooks(query: String) {
        _booksUiState.value = BooksUiState.Loading
        viewModelScope.launch {
            _booksUiState.value = try {
                val result = booksRepository.getBooksByQuery(query)
                BooksUiState.Success(books = result.books ?: listOf())
            } catch (e: IOException) {
                BooksUiState.Error
            }
        }
    }

    fun resetState() {
        _booksUiState.value = BooksUiState.Start
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}