package com.example.mvvmbooklist.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "book")
    data class BookEntity(

        var idBook: String,
        var isbn: String,
        var title: String,
        var authorFirstName: String,
        var authorLastName: String,
        var published: String,
        var publisher: String,
        var pagesNumber: String,
        var description: String,
        var imageUrl: String,
        var category: String) {


        @PrimaryKey(autoGenerate = true)
        var idTable: Int =0


    }