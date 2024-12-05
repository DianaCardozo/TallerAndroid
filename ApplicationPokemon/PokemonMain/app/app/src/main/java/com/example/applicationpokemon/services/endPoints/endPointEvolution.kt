package com.example.applicationpokemon.services.endPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.applicationpokemon.services.models.EvolutionResponse

interface endPointEvolution {
    @GET("evolution-chain/{Pokemon_id}/")
    suspend fun getEvolutionChain
                (@Path("Pokemon_id") pokemonID: Int): Response<EvolutionResponse>
}