package com.example.books.data


import com.example.books.model.Data
import com.example.books.model.ImageLinks
import com.example.books.model.VolumeInfo
import com.example.books.network.BooksApiService

/**
 * Repository retrieves books data from underlying data source.
 */
interface BooksRepository {
    /** Retrieves list of books from underlying data source */
    suspend fun getBooksByQuery(query: String): Data
}

/**
 * Network Implementation of repository that retrieves book data from underlying data source.
 */
class NetworkBooksRepository(
    private val booksApiService: BooksApiService
): BooksRepository {
    override suspend fun getBooksByQuery(query: String): Data =
        booksApiService.getBooksByQuery(query)
}