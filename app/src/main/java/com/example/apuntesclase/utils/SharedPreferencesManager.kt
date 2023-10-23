package com.example.apuntesclase.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.apuntesclase.MyApp
import com.example.apuntesclase.heros.HeroData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {
    /*public fun Test() : Int {
        return 3
    }*/

    private const val MyAppPreferencesName = "MySharedPreferences"

    private val shared: SharedPreferences by lazy { MyApp.Context.getSharedPreferences(MyAppPreferencesName,
        Context.MODE_PRIVATE
    ) }
    private val editor: SharedPreferences.Editor by lazy { shared.edit() }

    private const val AppOpenTimesKey = "AppOpenTimes"
    public var TimesOpenApp: Int
        get() = shared.getInt(AppOpenTimesKey, 0)
        set(newValue) {
            editor.putInt(AppOpenTimesKey, newValue)
            editor.apply()
        }

    private const val HeroesKey = "Heroes"
    public var Heroes: MutableList<HeroData>
        get() {
            val jsonString = shared.getString(HeroesKey, "")
            val listType = object : TypeToken<MutableList<HeroData>?>() {}.type
            val heroList = Gson().fromJson<MutableList<HeroData>?>(jsonString, listType)

            if (heroList == null) {
                return mutableListOf()
            }

            return heroList
        }
        set(value) {
            val jsonString = Gson().toJson(value)
            editor.putString(HeroesKey, jsonString)
            editor.apply()
        }
}