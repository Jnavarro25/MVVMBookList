package com.example.mvvmbooklist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbooklist.model.Book
import com.example.mvvmbooklist.repository.BookRepository
import com.example.practicalibrosreciclerview.datasource.ServiceListener

class BookViewModel(application: Application) : AndroidViewModel(application)
{
    private var bookRepository: BookRepository = BookRepository(application)
    private var bookInfoLiveData : MutableLiveData<ArrayList<Book>> = MutableLiveData()

    /*init {
        bookRepository.getBookList()
    }*/
    fun getAllBooksVM(): LiveData<ArrayList<Book>>{
        bookInfoLiveData.postValue( bookRepository.getAllBooks())
        return bookInfoLiveData
    }


}