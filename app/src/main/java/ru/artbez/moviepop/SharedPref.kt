package ru.artbez.moviepop

import android.content.Context
import android.preference.PreferenceManager

@Suppress("DEPRECATION")
class SharedPref {

    companion object{
        fun setPop(context: Context?, key: String, value: Boolean){
            val setPopShared = PreferenceManager.getDefaultSharedPreferences(context)
            setPopShared.edit().putBoolean(key, value).apply()
        }

        fun getPop(context: Context?, key: String): Boolean{
            val getPopShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getPopShared.getBoolean(key, false)
        }

    }

}