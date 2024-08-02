package com.example.noteapp.utills

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPrefernces: SharedPreferences

    fun unit(context: Context){
        sharedPrefernces = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var text: String?
        get() = sharedPrefernces.getString("text", "")
        set(value) = sharedPrefernces.edit()?.putString("text", value)!!.apply()

    var isOnBoardShown: Boolean
        get() = sharedPrefernces.getBoolean("board", false)
        set(value) = sharedPrefernces.edit().putBoolean("board", value).apply()
}
