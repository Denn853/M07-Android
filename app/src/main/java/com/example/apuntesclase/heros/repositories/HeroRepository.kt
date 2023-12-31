package com.example.apuntesclase.heros.repositories

import com.example.apuntesclase.heros.HeroData

interface HeroRepository {
    suspend fun GetHeros(offset: Int, limit: Int) : MutableList<HeroData>
}