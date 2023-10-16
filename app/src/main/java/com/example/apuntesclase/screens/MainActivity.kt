package com.example.apuntesclase.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclase.R
import com.example.apuntesclase.heros.HeroAdapter
import com.example.apuntesclase.heros.HeroProvider
import com.example.apuntesclase.heros.repositories.HeroMockRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val heroRecyclerView by lazy { findViewById<RecyclerView>(R.id.hero_RecyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        InitHeroRecyclerView()
        }

    fun InitHeroRecyclerView() {
        heroRecyclerView.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {

            val heroRepository = HeroMockRepository()
            val provider = HeroProvider(heroRepository)
            val heroList = provider.GetHeroes()
            val adapter = HeroAdapter(heroList)

            CoroutineScope(Dispatchers.Main).launch {
                heroRecyclerView.adapter = adapter
            }

        }
    }
}
