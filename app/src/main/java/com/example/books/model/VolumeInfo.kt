package com.example.books.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val title: String,
    private val authors: List<String>?,
    val publisher: String,
    val description: String,
    val pageCount: Int,
    val printType: String,
    val categories: List<String>,
    val maturityRating: String,
    @SerializedName("imageLinks") private val imgLinks: ImageLinks?,
    val language: String,
    val previewLink: String?
) {
    val imageUrls: ImageLinks
        get() = imgLinks ?: ImageLinks("", "")

    val authorsList: List<String>
        get() = authors ?: listOf<String>("Unknown")

    val link: String
        get() = previewLink?.replace("http", "https") ?: ""
}
