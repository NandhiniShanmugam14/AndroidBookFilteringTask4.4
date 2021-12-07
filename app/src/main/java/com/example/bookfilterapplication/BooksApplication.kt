package com.example.bookfilterapplication

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class BooksApplication: Application() {

    public lateinit var books: BookInterface

    override fun onCreate() {
        super.onCreate()
        books = initBooksService()
    }

    private fun initBooksService(): BookInterface {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://httpapibooks.mocklab.io/books/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
            .build()
        return retrofit.create(BookInterface::class.java)
    }

}