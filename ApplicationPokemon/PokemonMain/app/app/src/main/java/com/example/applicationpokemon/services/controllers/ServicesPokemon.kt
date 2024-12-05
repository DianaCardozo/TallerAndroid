package com.example.applicationpokemon.services.controllers

import kotlinx.coroutines.Dispatchers
import com.example.applicationpokemon.services.models.Pokemon
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.services.endPoints.endPointPokemon

class ServicesPokemon : ServiceBase (){fun getPokemonDetails(
    pokemonName: String,
    success: (details: Pokemon) -> Unit,
    error: () -> Unit
) {
    viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = getRetrofit()
                .create(endPointPokemon::class.java)
                .getPokemonDetails(pokemonName)

            val data = response.body()
            if (response.isSuccessful && data != null) {
                val pokemonConImg = data.copy(
                    imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${data.id}.png"
                )
                success(pokemonConImg)
            } else {
                println("Error en la API: ${response.errorBody()?.string()}")
                error()
            }
        } catch (e: Exception) {
            println(e)
            error()
        }
    }
}
}