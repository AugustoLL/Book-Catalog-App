package com.example.books.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
//    val kind: String,
//    val totalItems: Int,
    @SerializedName("items") val books: MutableList<Book>?
)
