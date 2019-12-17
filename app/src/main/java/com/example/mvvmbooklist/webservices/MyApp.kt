package com.example.mvvmbooklist.webservices

import android.app.Application

internal class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        var context: MyApp? = null
    }
}