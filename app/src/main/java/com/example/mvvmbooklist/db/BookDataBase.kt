package com.example.mvvmbooklist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmbooklist.db.dao.BookDao
import com.example.mvvmbooklist.db.entity.BookEntity

@Database(entities = [BookEntity::class],version = 1)
abstract class BookDataBase(): RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        private var instance: BookDataBase? = null

        fun getInstance(context: Context): BookDataBase {
            if (instance == null) {
                synchronized(BookDataBase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDataBase::class.java, "book"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

            }
        }

    }
}