package com.example.noteapp

import android.app.Application
import com.example.noteapp.utills.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
    }
}