package com.example.books.model

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val amount: Double,
    val currencyCode: String
)
