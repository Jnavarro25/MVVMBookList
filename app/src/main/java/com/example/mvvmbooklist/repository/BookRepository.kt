package com.example.mvvmbooklist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmbooklist.db.BookDataBase
import com.example.mvvmbooklist.db.dao.BookDao
import com.example.mvvmbooklist.model.Book
import com.example.mvvmbooklist.webservices.MyApp
import com.example.practicalibrosreciclerview.datasource.GetDataService
import com.example.practicalibrosreciclerview.datasource.ServiceListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.collections.ArrayList

class BookRepository(application: Application) :ServiceListener{


    private val getDataService: GetDataService = GetDataService(this)
    private  var booksFull: ArrayList<Book> = ArrayList()
    private var bookDao: BookDao
    //private var allNotes: LiveData<List<Book>>

    init {
        //val getDataService: GetDataService = GetDataService(this)
        val database: BookDataBase = BookDataBase.getInstance(
            application.applicationContext
        )!!
        bookDao = database.bookDao()
       //allNotes = bookDao.getAllBooks()
        GlobalScope.async{
            getDataOfWebService()
        }

    }

    suspend fun getDataOfWebService(){
        getDataService.getDataServiceJson()
    }

    override fun onResultSuccesGet(books: ArrayList<Book>)
    {
        booksFull= books
    }

    override fun onResultSuccess(result: Boolean) {
    }


    fun getAllBooks(): ArrayList<Book>{
        return booksFull
    }
}