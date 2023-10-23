package com.example.apuntesclase.heros

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclase.R

class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name by lazy { view.findViewById<TextView>(R.id.hero_cell_title) }
    private val description by lazy { view.findViewById<TextView>(R.id.hero_cell_descriptiom) }
    var currentHero: HeroData? = null

    fun SetupCellWithHero(hero:HeroData) {
        currentHero = hero
        name.text = hero.name
        description.text = hero.description
    }

}