package com.example.books.model

import kotlinx.serialization.Serializable

@Serializable
data class SaleInfo(
    val country: String,
    val saleability: String,
    val isEbook: Boolean,
    val listPrice: Price?,
    val retailPrice: Price?,
    val buyLink: String?
)
