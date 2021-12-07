package com.example.bookfilterapplication

import retrofit2.http.GET

interface BookInterface {
    @GET("/books")
    suspend fun getBooks() : List<Books>
}