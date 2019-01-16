package com.example.iurymiguel.retrofitexample.providers

import android.content.Context
import com.example.iurymiguel.retrofitexample.R

class SharedPreferencesProvider(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences(
        context.getString(R.string.shared_preferences),
        Context.MODE_PRIVATE
    )

    fun putString(key: String, value: String) {
        val editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String {
        return mSharedPreferences.getString(key, "")
    }

}