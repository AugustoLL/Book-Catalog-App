package com.example.books;

import android.app.Application
import com.example.books.data.AppContainer
import com.example.books.data.DefaultAppContainer

class BooksApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
