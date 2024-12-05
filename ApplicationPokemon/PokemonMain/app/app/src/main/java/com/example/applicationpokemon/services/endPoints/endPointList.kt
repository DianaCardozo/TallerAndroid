package com.example.applicationpokemon.services.endPoints

import com.example.applicationpokemon.services.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface endPointList {
    @GET("PokemonSpecies/{region_name}")
    suspend fun getPokemonsByRegion(@Path("name_region") regionName: String): Response<PokemonResponse>

}