package com.example.apuntesclase.heros.repositories

import com.example.apuntesclase.heros.HeroData

class HeroMockRepository : HeroRepository {

    companion object {
        private val heroesListHardcoded = mutableListOf(
            HeroData("Aquaman", "Es un pez que sabe nadar"),
            HeroData("Superman", "Debil ante una gema verde"),
            HeroData("BatMan", "No es super, solo rico"),
            HeroData("SpiderCerdo", "Tambien puede ser Harry popo ter"),
            HeroData("Sexo?", "ohhhh que rico papi"),
            HeroData("SuperUri", "to viejo el pibe este"),
        )
    }

    override suspend fun GetHeros(offset: Int, limit: Int): MutableList<HeroData> {

        val heroes = heroesListHardcoded

        if (heroes.size <= offset) {
            return mutableListOf()
        }

        if (heroes.size <= offset + limit) {
            return heroes.subList(offset, heroes.size - 1)
        }

        return heroes.subList(offset, offset + limit)
    }
}