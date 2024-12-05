package com.example.applicationpokemon.services.endPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.applicationpokemon.services.models.Pokemon

interface endPointRegion {
    @GET("pokemon/{name_Pokemon}")
    suspend fun getPokemonDetails(@Path("pokemon_name") pokemonName: String): Response<Pokemon>
}