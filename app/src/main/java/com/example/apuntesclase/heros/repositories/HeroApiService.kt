package com.example.apuntesclase.heros.repositories

import androidx.compose.animation.core.rememberInfiniteTransition
import com.example.apuntesclase.heros.HeroData
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class HeroApiService : HeroRepository {

    companion object {
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_KEY = "53b2fdb7b1ee54387a75c6852377b87d"
        const val PRIVATE_KEY = "2b937f154732994cf7d592790dabfc2ef6596356"

        val TimeStamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get() {
            val input = "$TimeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            val finalHash = BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
            return finalHash

        }

        val ApiService: RetrofitHeroApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitHeroApiService::class.java)
        }
    }

    interface RetrofitHeroApiService {
        @GET("characters")
        suspend fun GetHeroes(
            @Query("ts") timestamp: String = TimeStamp,
            @Query("apikey") apiKey: String = API_KEY,
            @Query("hash") hash: String = Hash,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int,
        ) : Response<CharactersResponse>
    }

    override suspend fun GetHeros(offset: Int, limit: Int): MutableList<HeroData> {

        val response = ApiService.GetHeroes(offset = offset, limit = limit)

        if (response.isSuccessful) {

            response.body()?.data?.results?.let { heroes ->
                return heroes
            } ?: kotlin.run {
                //Gestionar aviso de que no hemos reactivado los datos
                return mutableListOf()
            }

        } else {
            //Gestionar aviso de que no ha funcionando por algun motivo
            return mutableListOf()
        }
    }

}