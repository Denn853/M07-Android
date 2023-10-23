package com.example.apuntesclase.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclase.R
import com.example.apuntesclase.heros.HeroAdapter
import com.example.apuntesclase.heros.HeroData
import com.example.apuntesclase.heros.HeroProvider
import com.example.apuntesclase.heros.repositories.HeroMockRepository
import com.example.apuntesclase.heros.repositories.HeroSharedDatabase
import com.example.apuntesclase.utils.Shared
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

        val tempList = mutableListOf(
            HeroData("Test Hero1", "Desc"),
            HeroData("Test Hero2", "Desc"),
            HeroData("Test Hero3", "Desc"),
            HeroData("Test Hero4", "Desc"),
        )
        Shared.Heroes = tempList
        //Obtenemos la lista de heroes de las preferencias
        //Añadimos un nuevo heroe
        //Actualizamos la lista


        CoroutineScope(Dispatchers.IO).launch {

            val heroRepository = HeroSharedDatabase() //Nuevo Repo
            val provider = HeroProvider(heroRepository)
            val heroList = provider.GetHeroes()
            val adapter = HeroAdapter(heroList)

            CoroutineScope(Dispatchers.Main).launch {
                heroRecyclerView.adapter = adapter
            }

        }
    }
}
