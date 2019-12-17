package com.example.mvvmbooklist.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbooklist.R
import com.example.mvvmbooklist.adapter.BookAdapter
import com.example.mvvmbooklist.model.Book
import com.example.mvvmbooklist.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter = BookAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeComponentsView()

        recyclerView = findViewById(R.id.rV_bookList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter


        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.getAllBooksVM().observe(this,Observer<ArrayList<Book>>(){
            t ->  adapter.setBooks(t!!)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {

                    return false
                }
            })
        return true
    }


    private fun makeComponentsView() {

        /**recyclerView = findViewById(R.id.rV_bookList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager*/




        fab_add_book.setOnClickListener {
            //val listToAdd = Intent(this, AddBookActivity::class.java)
            //startActivity(listToAdd)
        }
        //swipeRefreshLayout = findViewById(R.id.srf_swipe_update)
    }
}
