package com.example.books.network

import com.example.books.model.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooksByQuery(
        @Query("q") query: String
    ): Data
}