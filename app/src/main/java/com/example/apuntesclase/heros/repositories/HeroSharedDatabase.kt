package com.example.apuntesclase.heros.repositories

import com.example.apuntesclase.heros.HeroData
import com.example.apuntesclase.utils.Shared
import java.time.OffsetDateTime

class HeroSharedDatabase : HeroRepository {

    override suspend fun GetHeros(offset: Int, limit: Int): MutableList<HeroData> {

        val heroes = Shared.Heroes

        if (heroes.size <= offset) {
            return mutableListOf()
        }

        if (heroes.size <= offset + limit) {
            return heroes.subList(offset, heroes.size - 1)
        }

        return Shared.Heroes.subList(offset, offset + limit)
    }

}