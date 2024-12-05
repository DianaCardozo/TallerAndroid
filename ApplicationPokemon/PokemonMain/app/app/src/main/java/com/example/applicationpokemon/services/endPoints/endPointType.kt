package com.example.applicationpokemon.services.endPoints
import retrofit2.Response
import retrofit2.http.GET
import com.example.applicationpokemon.services.models.TypeResponse

interface endPointType {
    @GET("type/")
    suspend fun getPokemonTypes(): Response<TypeResponse>
}