package com.example.apuntesclase.heros

import com.example.apuntesclase.heros.repositories.HeroRepository

class HeroProvider(private val heroRepository: HeroRepository) {

    suspend fun GetHeroes(offset: Int, limit: Int) : MutableList<HeroData> {
        return heroRepository.GetHeros(offset = offset, limit = limit)
    }

}