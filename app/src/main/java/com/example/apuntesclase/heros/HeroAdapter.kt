package com.example.apuntesclase.heros

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclase.R
import com.example.apuntesclase.heros.repositories.HeroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroAdapter(private val repository: HeroRepository, private val paginationSize: Int = 20) : RecyclerView.Adapter<HeroViewHolder>() {

    private var heroList: MutableList<HeroData> = mutableListOf()
    private val provider: HeroProvider = HeroProvider(repository)
    private var requestingHeroes: Boolean = false

    init {
        GetMoreHeroes()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetupCellWithHero(heroList[position])

        if (position >= heroList.size - paginationSize) {
            GetMoreHeroes()
        }
    }

    private fun GetMoreHeroes() {

        if (requestingHeroes) {
            return
        }

        requestingHeroes = true

        CoroutineScope(Dispatchers.IO).launch {

            val extraHeroes = provider.GetHeroes(heroList.size, paginationSize)

            CoroutineScope(Dispatchers.Main).launch {
                heroList.addAll(extraHeroes)
                notifyDataSetChanged()
                requestingHeroes = false
            }
        }

    }
}