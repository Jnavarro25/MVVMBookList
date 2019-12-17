package com.example.practicalibrosreciclerview.datasource

import androidx.lifecycle.LiveData
import com.example.mvvmbooklist.model.Book
import java.util.*
import kotlin.collections.ArrayList

interface ServiceListener {
    fun onResultSuccesGet(books: ArrayList<Book>)
    fun onResultSuccess(result: Boolean)
}