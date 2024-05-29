package com.example.books.data

import com.example.books.network.BooksApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val booksApi: BooksApiService
    val booksRepository: BooksRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer: AppContainer{
    private val baseUrl =
        "https://www.googleapis.com/books/v1/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    override val booksApi: BooksApiService by lazy {
        retrofit.create()
    }

    /**
     * DI implementation for Books repository
     */
    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(booksApi)
    }
}