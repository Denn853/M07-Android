package com.example.apuntesclase.heros

class HeroProvider {
    companion object {
        private val heroList = listOf(
            HeroData("Aquaman", "Es un pez que sabe nadar"),
            HeroData("Superman", "Debil ante una gema verde"),
            HeroData("BatMan", "No es super, solo rico"),
            HeroData("SpiderCerdo", "Tambien puede ser Harry popo ter"),
            HeroData("Sexo?", "ohhhh que rico papi"),
            HeroData("SuperUri", "to viejo el pibe este"),
        )

        fun GetAllHeros() : List<HeroData> = heroList
    }
}