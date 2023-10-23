package com.example.apuntesclase.heros.repositories

import com.example.apuntesclase.heros.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(@SerializedName("code") val statusCode: String, val data: CharactersResponseData)

data class CharactersResponseData(val total: Int, val count: Int, val results: MutableList<HeroData>)
