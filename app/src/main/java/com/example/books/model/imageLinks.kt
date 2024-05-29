package com.example.books.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    private var smallThumbnail: String?,
    private var thumbnail: String?
) {
    val formattedThumbnail: String
        get() = thumbnail?.replace("http", "https") ?: ""
    val formattedSmallThumbnail: String
        get() = smallThumbnail?.replace("http", "https") ?: ""
}
