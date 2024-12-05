package com.example.applicationpokemon.services.driverAdapters

import com.example.applicationpokemon.services.controllers.ServicesPokemon
import com.example.applicationpokemon.services.models.Pokemon

class AdapterPokemon {
    private val service: ServicesPokemon = ServicesPokemon()

    fun getPokemonDetails(
        pokemonName: String,
        loadData: (Pokemon) -> Unit,
        errorData: () -> Unit
    ) {
        this.service.getPokemonDetails(
            pokemonName = pokemonName,
            success = { loadData(it) },
            error = { errorData() }
        )
    }
}