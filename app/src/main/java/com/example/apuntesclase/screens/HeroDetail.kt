package com.example.apuntesclase.screens

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntesclase.R
import com.example.apuntesclase.heros.HeroData

class HeroDetail : ComponentActivity() {

    val nameText by lazy { findViewById<TextView>(R.id.hero_detail_title) }
    val descriptionText by lazy { findViewById<TextView>(R.id.hero_detail_description) }
    val backArrow by lazy { findViewById<ImageButton>(R.id.hero_detail_back_arrow) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hero_detail_screen)

        var hero: HeroData? = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hero = intent.getSerializableExtra("Hero", HeroData::class.java)
        } else {
            hero = intent.getSerializableExtra("Hero") as? HeroData
        }

        hero?.let { hero ->
            nameText.text = hero.name
            descriptionText.text = hero.description
        }

        backArrow.setOnClickListener {
            finish()
        }

    }
}