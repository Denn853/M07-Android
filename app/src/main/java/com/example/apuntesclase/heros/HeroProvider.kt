package com.example.apuntesclase.heros

import com.example.apuntesclase.heros.repositories.HeroRepository

class HeroProvider(private val heroRepository: HeroRepository) {

    suspend fun GetHeroes() : MutableList<HeroData> {
        return heroRepository.GetHeros()
    }

}