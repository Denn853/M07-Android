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

    override suspend fun GetHeros(): MutableList<HeroData> {
        return heroesListHardcoded
    }
}