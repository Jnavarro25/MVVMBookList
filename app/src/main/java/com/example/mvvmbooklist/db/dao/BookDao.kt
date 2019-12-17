package com.example.mvvmbooklist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmbooklist.model.Book

@Dao
interface BookDao
{
    /**
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Query("SELECT * FROM book")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("DELETE FROM book WHERE idBook > idBook")
    fun deleteBook(idBook:String)*/

}