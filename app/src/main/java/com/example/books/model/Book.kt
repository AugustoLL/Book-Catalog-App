package com.example.books.model

import android.util.Log
import kotlinx.serialization.Serializable

@Serializable
class Book (
    val id: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo,
) {
    fun logBookData(logTag: String = "TEST") {
        Log.d(
            "TEST",
            "Title: ${volumeInfo.title}\n" +
                    "--SALE INFO:\n" +
                    "----Buy Link: ${saleInfo.buyLink}\n" +
                    "----Country: ${saleInfo.country}\n" +
                    "----Is Ebook: ${saleInfo.isEbook}\n" +
                    "----List Price: ${saleInfo.listPrice}\n" +
                    "----Retail Price: ${saleInfo.retailPrice}\n" +
                    "----Saleability: ${saleInfo.saleability}\n" +
                    "--VOLUME INFO:\n" +
                    "----Description: ${volumeInfo.description}\n" +
                    "----Language: ${volumeInfo.language}\n" +
                    "----Maturity Rating: ${volumeInfo.maturityRating}\n" +
                    "----Page Count: ${volumeInfo.pageCount}\n" +
                    "----Print Type: ${volumeInfo.printType}\n" +
                    "----Publisher: ${volumeInfo.publisher}\n" +
                    "----Authors List: ${volumeInfo.authorsList}\n" +
                    "----Categories: ${volumeInfo.categories}\n" +
                    "----Formatted Thumbnail: ${volumeInfo.imageUrls.formattedThumbnail}\n" +
                    "----Formatted Small Thumbnail: ${volumeInfo.imageUrls.formattedSmallThumbnail}\n" +
                    "----------------------------------------------------------------"
        )
    }
}