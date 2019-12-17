package com.example.mvvmbooklist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbooklist.R
import com.example.mvvmbooklist.model.Book
import com.example.mvvmbooklist.webservices.MyApp
import com.squareup.picasso.Picasso

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookHolder>(){

    private var books: List<Book> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cv_item_book, parent, false)
        return BookHolder(itemView)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun setBooks(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val currentBook = books[position]
        holder.dataAsign(currentBook) }

    inner class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var imageBook: ImageView = itemView.findViewById(R.id.iv_book)
        private var bookTitle: TextView = itemView.findViewById(R.id.tV_book_title)
        private var authorName: TextView = itemView.findViewById(R.id.tV_author_name)
        private var category: TextView = itemView.findViewById(R.id.tV_category)

        fun dataAsign(book: Book) {
            Picasso.get().load(book.imageUrl).into(imageBook)
            bookTitle.text = MyApp.context!!.getString(R.string.book_title, book.title)
            authorName.text = MyApp.context!!.getString(R.string.author_name, book.authorFirstName, book.authorLastName)
            category.text = MyApp.context!!.getString(R.string.category, book.category)
        }

    }

}