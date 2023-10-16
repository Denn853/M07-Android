package com.example.apuntesclase.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.apuntesclase.R
import com.example.apuntesclase.heros.HeroAdapter
import com.example.apuntesclase.heros.HeroData
import com.example.apuntesclase.heros.HeroProvider

class MainActivity : ComponentActivity() {

    val table by lazy { findViewById<RecyclerView>(R.id.my_recyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)
        table.adapter = HeroAdapter(HeroProvider.GetAllHeros())

    }
}
