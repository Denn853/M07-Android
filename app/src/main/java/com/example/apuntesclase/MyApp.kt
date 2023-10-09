package com.example.apuntesclase

import android.app.Application
import android.content.Context

class MyApp: Application() {
    companion object {
        private lateinit var instance: MyApp

        public val Context: MyApp get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}