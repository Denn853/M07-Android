package com.example.apuntesclase.heros.repositories

import com.example.apuntesclase.heros.HeroData
import com.example.apuntesclase.utils.Shared

class HeroSharedDatabase : HeroRepository {

    override suspend fun GetHeros(): MutableList<HeroData> {
        return Shared.Heroes
    }

}